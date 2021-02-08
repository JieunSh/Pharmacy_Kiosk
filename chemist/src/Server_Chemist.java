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
	Boolean input_Flag;					//qr�ڵ� ������ ���°��� �˷��ִ� �÷���
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
			System.out.println("Ŭ���̾�Ʈ�κ��� ������ ���۹��� �غ� �Ϸ�");
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			accept_Flag = true;
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�");
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
	public void getInfo() {										//wait ��� ������ ���� �ޱ� ���� ���������� not wait ��� ������ ����

		pw.println("3/waiting...");

		System.out.println("waiting ����!");

		while (true) {

			String clientMessage;
			try {
				Thread.sleep(1000);
				if (stop_Flag == true) {
					stop_Flag = false;
					break;
				}
				System.out.println("�����");
				clientMessage = br.readLine();
				
				
			//	System.out.println("���ƴ�");
				if(clientMessage != null) {
					System.out.println("clientMessage : " + clientMessage);
					String[] tmp = clientMessage.split("/");
					
					if(tmp[0].equals("0")) {				//ó���� qr�ڵ� �޾�����
						p_k.jpanel3.model.addElement("ó���� ������ȣ:"+tmp[1]);
						
						Drug_Info di = new Drug_Info(clientMessage);
						di.print_info();
						
						FileIO fi = new FileIO();
						String filePath = "C:\\Users\\Seo\\Desktop\\test.txt";
						fi.UpdateFile(filePath, clientMessage);
						for(int i= 0; i<p_k.jpanel3.model.size();i++) {
							String element= p_k.jpanel3.model.elementAt(i).toString();
							String tmp1[] = element.split(":");
							if(tmp1[1].equals(tmp[1])) {
								System.out.println(tmp1[1]+ "ã��");		//tmp1[1]�� �Ϸ�� ó���� ������ȣ
								pw.println("4/"+tmp1[1]);				//�Ϸ� �޽��� ������
								p_k.jpanel3.model.removeElementAt(i);// ó���� ������ȣ �����ϱ�
								break;
							}
						}
					}else if(tmp[0].equals("1")) {			//�౹�� ������ ���� ����ȣ �޾�����
						System.out.println("�౹�� ����");
						p_k.jpanel3.model.addElement("�౹�� ������ȣ:"+tmp[1]);
						//pw.println(tmp[0]+"����");
					}
					
					
				}

				///�˸��� ���� Ŭ���� �ϳ� ����
				//���⿡ �߰�!
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