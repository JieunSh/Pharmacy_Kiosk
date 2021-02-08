
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server_Kiosk implements Runnable {
	public static final int ServerPort = 9995;
	public static boolean scan_Flag = false;
	public static boolean cmp_Flag = false;
	public static boolean cmp_Flag2 = false;
	public static boolean fail_Flag = false;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;

	OutputStream os = null;
	OutputStreamWriter osw = null;
	PrintWriter pw = null;
	ServerSocket serverSocket;
	Socket client;
	static String qrCode_Info;
	Frame_Kiosk win;
	public Server_Kiosk(Frame_Kiosk win) {
		// TODO Auto-generated constructor stub
		this.win = win;
	}
	public void run(){
		try {
			System.out.println("Connecting..");
			serverSocket = new ServerSocket(ServerPort);
			client = serverSocket.accept();
			System.out.println("Receiving.");


			is = client.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);

			// outputStream �����ͼ� (�� ��Ʈ��) StreamWriter�� PrintWriter�� �����ش� (���� ��Ʈ��)
			os = client.getOutputStream();
			osw = new OutputStreamWriter(os, "UTF-8");
			pw = new PrintWriter(osw, true);
			String tmp = null;

			tmp = br.readLine();
			System.out.println(tmp);

			while (true) {
				//System.out.println("��ĵ ��������");
				while(true) {
					Thread.sleep(1000);
					if(scan_Flag){
						scan_Flag = false;
						break;
					}
				}
				pw.println("Scan");
				System.out.println("send Scan");
				qrCode_Info = null;
				qrCode_Info = br.readLine();	//��ĵ��� ������ ���� ���


				if(qrCode_Info.equals("Scan Fail")) {
					System.out.println(qrCode_Info);
					fail_Flag = true;
				}
				else {
					System.out.println("Received: " + qrCode_Info + "");
					Client_Kiosk.br = null;
					Client_Kiosk.br = new BufferedReader(Client_Kiosk.inputStreamReader);
					++win.jpanel03.TOTAL_CUSTOMER;			//qr�ڵ� ������ ������ȣ ����
					cmp_Flag = true;
					cmp_Flag2 = true;
				}


			}
		}catch (Exception e) {
			System.out.println("S: Error");
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
