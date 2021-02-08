import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Chemist implements Runnable {
	static Boolean accept_Flag;
	static Boolean stop_Flag;
	ServerSocket serverSocket;
	Socket socket;

	OutputStream outputStream;
	OutputStreamWriter outputStreamWriter;
	static PrintWriter pw;

	InputStream inputStream;
	InputStreamReader inputStreamReader;
	BufferedReader br;
	pharmacist_Kiosk p_k;
	Boolean input_Flag;					//qr코드 정보가 오는것을 알려주는 플레그
	public Server_Chemist(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		serverSocket = null;
		socket = null;
		input_Flag = false;
		outputStream = null;
		outputStreamWriter = null;
		pw = null;

		inputStream = null;
		inputStreamReader = null;
		br = null;
		accept_Flag = false;
		stop_Flag = false;
		try {
			System.out.println("클라이언트로부터 데이터 전송받을 준비 완료");
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			accept_Flag = true;
			System.out.println("클라이언트 연결 완료");
			System.out.println("socket : " + socket);
			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			br = new BufferedReader(inputStreamReader);
			
			outputStream = socket.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			pw = new PrintWriter(outputStreamWriter, true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void set_Stop_Flag(Boolean flag) {
		stop_Flag = flag;
	}
	public void getInfo() {										//wait 명령 내리고 정보 받기 정보 받지않으면 not wait 명령 내리고 종료

		pw.println("3/waiting...");

		System.out.println("waiting 전송!");

		while (true) {

			String clientMessage;
			try {
				Thread.sleep(1000);
				if (stop_Flag == true) {
					stop_Flag = false;
					break;
				}
				System.out.println("대기중");
				clientMessage = br.readLine();
				
				
			//	System.out.println("대기아님");
				if(clientMessage != null) {
					System.out.println("clientMessage : " + clientMessage);
					String[] tmp = clientMessage.split("/");
					
					if(tmp[0].equals("0")) {				//처방전 qr코드 받았을때
						p_k.jpanel3.model.addElement("처방전 접수번호:"+tmp[1]);
						
						Drug_Info di = new Drug_Info(clientMessage);
						di.print_info();
						
						FileIO fi = new FileIO();
						String filePath = "C:\\Users\\Seo\\Desktop\\test.txt";
						fi.UpdateFile(filePath, clientMessage);
						for(int i= 0; i<p_k.jpanel3.model.size();i++) {
							String element= p_k.jpanel3.model.elementAt(i).toString();
							String tmp1[] = element.split(":");
							if(tmp1[1].equals(tmp[1])) {
								System.out.println(tmp1[1]+ "찾음");		//tmp1[1]은 완료된 처방전 접수번호
								pw.println("4/"+tmp1[1]);				//완료 메시지 보내기
								p_k.jpanel3.model.removeElementAt(i);// 처방전 접수번호 삭제하기
								break;
							}
						}
					}else if(tmp[0].equals("1")) {			//약국약 접수를 위한 대기번호 받았을때
						System.out.println("약국약 받음");
						p_k.jpanel3.model.addElement("약국약 접수번호:"+tmp[1]);
						//pw.println(tmp[0]+"받음");
					}
					
					
				}

				///알림을 위한 클래스 하나 만들어서
				//여기에 추가!
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	public void putInfo(String tmp) {
		pw.println(tmp);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run");
		getInfo();
		System.out.println("end");
	}
}