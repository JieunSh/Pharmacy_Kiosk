
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client_Kiosk implements Runnable {
	Socket socket = null;
	int success_Falg;
	OutputStream outputStream ;
	OutputStreamWriter outputStreamWriter;
	static PrintWriter pw;

	InputStream inputStream;
	static InputStreamReader inputStreamReader;
	static BufferedReader br;

	String qrCode_Info;
	Boolean stop_Flag;
	Boolean wait_Flag;					//�����ư Ȱ��ȭ ����
	Frame_Kiosk win;
	public Client_Kiosk(Frame_Kiosk win) {
		this.win = win;
		stop_Flag = false;
		wait_Flag = false;
		try {
			socket = new Socket("localhost", 9000);
			System.out.println("�����ǻ�Ϳ� ���� �Ϸ�!");
			success_Falg = 1;
			outputStream = socket.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			pw = new PrintWriter(outputStreamWriter, true);

			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			br = new BufferedReader(inputStreamReader);



			//success_Falg = 2;		//�����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success_Falg = 0;
		}
	}
	public void input_Data(String totalNum) {		//�౹�� ������ ���� �޼ҵ�
		pw.println("1/"+win.jpanel03.TOTAL_CUSTOMER+"/"+totalNum);
		System.out.println("���������� �޽��� ����");
	}

	class BrThread implements Runnable{

		@Override
		public void run() {
			String waitmessage = null;
			// TODO Auto-generated method stub
			try {
				while(true) {
					Thread.sleep(1000);
					waitmessage = br.readLine();

					System.out.println(waitmessage);
					String tmp[] = waitmessage.split("/");
					if(tmp[0].equals("3")) {			//���� ��/Ȱ��ȭ
						if(tmp[1].equals("waiting...")) {
							wait_Flag =true;
						}else if(tmp[1].equals("not wait")) {
							wait_Flag =false;
						}
					}else if(tmp[0].equals("4")) {		//�Ϸ� �޽���
						System.out.println("������ȣ : "+tmp[1] +"�� ����");
						win.jpanel03.COMPELTE_CUSTOMER++;		//�Ϸ� �� 1����
						win.jpanel01.comments.append("������ȣ : "+tmp[1] +"�� ����\r\n");
						
					}
						
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			Thread t = new Thread(new BrThread());
			t.start();
			while (true) {
				Thread.sleep(5000);						//5�ʰ����� qr�ڵ� ������ ���ŵƴ��� üũ!
				if(Server_Kiosk.cmp_Flag2) {
					System.out.println("QR�ڵ� ���� ���� �Ϸ�!");
					Server_Kiosk.cmp_Flag2 = false;
					
					qrCode_Info ="0/"+win.jpanel03.TOTAL_CUSTOMER+"/"+ Server_Kiosk.qrCode_Info;
					pw.println(qrCode_Info); // ���� ������ ������ ����
					if (stop_Flag == true) {
						stop_Flag = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			stop_Flag = true;
		}
	}

}
