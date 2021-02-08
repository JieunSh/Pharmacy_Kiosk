import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



class Jpanel1 extends JPanel{								//���� �г�
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	private Graphics screenGraphic;
	private Image screenImage;
	public Image screen;
	private ImageIcon enterImage = new ImageIcon(this.getClass().getResource("images/enter.png"));
	public JButton btnenter = new JButton(enterImage);
	private Image a= new ImageIcon(this.getClass().getResource("images/main.png")).getImage();
	private Frame_Kiosk win;
	TextArea comments ;
	public Jpanel1(Frame_Kiosk win) {
		this.win = win;
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);
		screen = a;

		btnenter.setBounds(293, 470, 282, 171);
		btnenter.setBorderPainted(false);
		btnenter.setContentAreaFilled(false);
		btnenter.setFocusPainted(false);

		comments = new TextArea("\r\n");  
		JScrollPane scrollPane=  new JScrollPane(comments,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		scrollPane.setBounds(620,50,260,330);
		scrollPane.setVisible(true);
		
		add(btnenter);
		btnenter.addActionListener(new MyActionListener());
		Thread t = new Thread(Main_Kiosk.c);
		t.start();
	}
	public void setComments(String tmp) {
		comments.append(tmp+"\r\n");
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//ó������⸦ Ŭ���ؾ� �����ư ������ �����
			if(Main_Kiosk.c.wait_Flag==true) {
				win.change("panel2");
			}else {
				JOptionPane message=new JOptionPane();
				message.showMessageDialog(null, "ó������ �������� �ƴմϴ�. ����� �ٽ� �õ��� �ֽʽÿ�.", "����", JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	public void paint(Graphics g) { // ��ӵ� �޼ҵ�
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);// 1280X700�� �̹��� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��Ͽ� �׷��� ��ü �ҷ���
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}
	private void screenDraw(Graphics g) {
		g.drawImage(screen, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();


	}
}

@SuppressWarnings("serial")
class Jpanel2 extends JPanel{	
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	private Graphics screenGraphic;
	private Image screenImage;
	public Image screen;//���� ���� �г�
	private ImageIcon Me_Image = new ImageIcon(this.getClass().getResource("images/medicine_btn.png"));
	public JButton btnMedicine = new JButton(Me_Image);

	private ImageIcon Sc_Image = new ImageIcon(this.getClass().getResource("images/scan_btn.png"));
	public JButton btnScan = new JButton(Sc_Image);

	private ImageIcon B_Image = new ImageIcon(this.getClass().getResource("images/back_btn.png"));
	public JButton btnBack = new JButton(B_Image);
	private Image a= new ImageIcon(this.getClass().getResource("images/select.png")).getImage();
	private Frame_Kiosk win;

	public Jpanel2(Frame_Kiosk win) {
		this.win = win;
		setLayout(null);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
		screen = a;

		btnMedicine.setBounds(0, 0, Me_Image.getIconWidth(), Me_Image.getIconHeight());


		btnMedicine.setLocation(70,240);
		btnMedicine.setBorderPainted(false);
		btnMedicine.setContentAreaFilled(false);
		btnMedicine.setFocusPainted(false);
		add(btnMedicine);
		btnMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Kiosk.c.input_Data(""+(++win.jpanel03.TOTAL_CUSTOMER));
				win.change("panel3");
			}
		});

		btnScan.setBounds(0, 0, Sc_Image.getIconWidth(), Sc_Image.getIconHeight());

		btnScan.setLocation(480,240);
		btnScan.setBorderPainted(false);
		btnScan.setContentAreaFilled(false);
		btnScan.setFocusPainted(false);
		add(btnScan);
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel4");
			}
		});

		btnBack.setBounds(0, 0, B_Image.getIconWidth(), B_Image.getIconHeight());

		btnBack.setLocation(660,580);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel1");
			}
		});



	}
	public void paint(Graphics g) { // ��ӵ� �޼ҵ�
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);// 1280X700�� �̹��� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��Ͽ� �׷��� ��ü �ҷ���
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}
	private void screenDraw(Graphics g) {
		g.drawImage(screen, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();


	}

}

class ScanTimer extends TimerTask{			//Ÿ�̸ӿ� �Բ� ��ĵ�Ϸ� flag�� �۵��ߴ��� �˾ƺ��� Ŭ����
	final int WAIT_TIME = 30;
	int count_time;
	Frame_Kiosk win;
	public ScanTimer(Frame_Kiosk win) {
		this.win = win;
		count_time = WAIT_TIME;

	}
	@Override
	public void run() {
		Jpanel4.count_lbl.setText(""+count_time);
		count_time--;
		if(Server_Kiosk.cmp_Flag) {		//��ĵ������
			Server_Kiosk.cmp_Flag = false;
			count_time = WAIT_TIME;
			
			win.change("panel3");
			win.jpanel04.qr_btn.setEnabled(true);
			this.cancel();
		}
		if(count_time == 0 || Server_Kiosk.fail_Flag) {		//��ĵ ���н� (30�ʰ� ������)
			win.change("panel1");		//�ʱ�ȭ������ �ǵ��ư���
			Server_Kiosk.fail_Flag = false;
			count_time = WAIT_TIME;
			Main_Kiosk.s.br = null;			//������ ����
			Main_Kiosk.s.br = new BufferedReader(Main_Kiosk.s.isr);
			Main_Kiosk.s.pw.println("Scan Cancel");		//��ĳ�� ��ĵ ��Ҹ��
			win.jpanel04.qr_btn.setEnabled(true);
			this.cancel();	
		}
	}
}

class TicketTimer extends TimerTask{		//���� �Ϸ��� �ð���� Ÿ�̸�
	private Frame_Kiosk win;
	int timer_Count;
	public TicketTimer(Frame_Kiosk win) {
		// TODO Auto-generated constructor stub
		this.win = win;
		timer_Count = 10;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		win.jpanel03.timer_count.setText(""+timer_Count);
		timer_Count--;
		if(timer_Count == 0) {
			this.cancel();
		}
	}
	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		timer_Count = 10;
		win.change("panel1");
		return super.cancel();
	}

}
class Jpanel3 extends JPanel {		//��ȣǥ ����ϴ� �г�
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	private Graphics screenGraphic;
	private Image screenImage;
	public Image screen;
	private ImageIcon okImage = new ImageIcon(this.getClass().getResource("images/ok_btn.png"));
	public JButton ok_btn = new JButton(okImage);
	private Image a= new ImageIcon(this.getClass().getResource("images/number.png")).getImage();
	public static int COMPELTE_CUSTOMER = 1;		//�Ϸ��ο�
	public static int NOW_CUSTOMER = 0;		//�Ϸ��ο�
	public static int TOTAL_CUSTOMER = 0;	//���� ������ȣ
	private Frame_Kiosk win;
	JLabel count_label = new JLabel("");
	JLabel wait_label = new JLabel("");
	
	JLabel timer_count = new JLabel("");
	//	JButton confirm_btn;
	Timer ticket_timer;
	TicketTimer ticket_T;
	public Jpanel3(Frame_Kiosk win) {
		setLayout(null);
		this.win = win;
		setVisible(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		screen = a;


		ticket_timer = new Timer();
		ticket_T = new TicketTimer(win);

		count_label.setText(""+ TOTAL_CUSTOMER);
		count_label.setFont(new Font("DAUL-EQN2", Font.BOLD, 30));
		count_label.setForeground(Color.red);
		
		NOW_CUSTOMER = TOTAL_CUSTOMER - COMPELTE_CUSTOMER;		//����ο����ϱ�
		wait_label.setText(""+ NOW_CUSTOMER);
		wait_label.setFont(new Font("DAUL-EQN2", Font.BOLD, 26));
		wait_label.setForeground(Color.red);

		timer_count.setFont(new Font("DAUL-EQN2", Font.BOLD, 22));
		timer_count.setForeground(Color.black);


		count_label.setBounds(420, 90, 300, 300);
		wait_label.setBounds(500,300,200,100);
		timer_count.setBounds(460,413,100,100);

		ok_btn.setBounds(0, 0, okImage.getIconWidth(), okImage.getIconHeight());
		ok_btn.setLocation(350,500);
		ok_btn.setBorderPainted(false);
		ok_btn.setContentAreaFilled(false);
		ok_btn.setFocusPainted(false);

		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticket_T.cancel();
			}
		});


		this.add(count_label);
		this.add(wait_label);
		this.add(timer_count);
		this.add(ok_btn);
		ticket_timer.schedule(ticket_T, 1,1000);

	}
	
	public void paint(Graphics g) { // ��ӵ� �޼ҵ�
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);// 1280X700�� �̹��� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��Ͽ� �׷��� ��ü �ҷ���
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}
	private void screenDraw(Graphics g) {
		g.drawImage(screen, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();


	}


}

class Jpanel4 extends JPanel {	
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	private Graphics screenGraphic;
	private Image screenImage;
	public Image screen;
	private ImageIcon qrImage = new ImageIcon(this.getClass().getResource("images/qrScan_btn.png"));
	public JButton qr_btn = new JButton(qrImage);
	private Image a= new ImageIcon(this.getClass().getResource("images/scan.png")).getImage();
	private Frame_Kiosk win;

	static JLabel count_lbl = new JLabel("");

	public Jpanel4(Frame_Kiosk win) {
		setLayout(null);
		this.win = win;
		setVisible(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		screen = a;
		qr_btn.setBounds(0, 0, qrImage.getIconWidth(), qrImage.getIconHeight());
		qr_btn.setLocation(320,250);
		count_lbl.setBounds(0, 10, 50, 50);

		count_lbl.setText("");
		add(qr_btn);
		add(count_lbl);
		qr_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer timer = new Timer();
				qr_btn.setEnabled(false);
				timer.schedule(new ScanTimer(win), 1,1000);
				Server_Kiosk.scan_Flag = true;

			}
		});

	}
	public void paint(Graphics g) { // ��ӵ� �޼ҵ�
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);// 1280X700�� �̹��� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��Ͽ� �׷��� ��ü �ҷ���
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}
	private void screenDraw(Graphics g) {
		g.drawImage(screen, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();


	}
}

class Jpanel0 extends JPanel{															// �׷��� �����ϱ�!!!!
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	public JButton scanner_Ser_Open_Btn;
	Boolean open_Flag;
	Boolean con_Flag;
	public JButton start_Btn;
	JButton chemist_Connect_Btn;
	//private Graphics screenGraphic;
	//private Image screenImage;
	//public Image screen;
	//private ImageIcon enterImage = new ImageIcon(this.getClass().getResource("images/enter.png"));
	//public JButton btnenter = new JButton(enterImage);
	//private Image a= new ImageIcon(this.getClass().getResource("images/main.png")).getImage();
	private Frame_Kiosk win;

	public Jpanel0(Frame_Kiosk win) {
		this.win = win;
		open_Flag = false;
		con_Flag = false;

		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);
		scanner_Ser_Open_Btn= new JButton("��ĳ�� ���� ����");
		scanner_Ser_Open_Btn.setBounds(0,0,200,100);
		scanner_Ser_Open_Btn.setLocation(200,200);
		scanner_Ser_Open_Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Main_Kiosk.s == null) {						//��ĳ�ʿ� �����ϴ� ���� ����
					Main_Kiosk.s = new Server_Kiosk(win);

					Thread t = new Thread(Main_Kiosk.s);
					t.start();
					open_Flag= true;
				}
			}
		});
		add(scanner_Ser_Open_Btn);
		chemist_Connect_Btn= new JButton("��� ������ �����ϱ�");
		chemist_Connect_Btn.setBounds(0,0,200,100);
		chemist_Connect_Btn.setLocation(500,200);
		chemist_Connect_Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Main_Kiosk.c == null) {							//��� ������ �����ϱ� ���� ����Ʈ �õ�		
					Main_Kiosk.c = new Client_Kiosk(win);

					while(true) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(Main_Kiosk.c.success_Falg== 0) {	//����
							JOptionPane message=new JOptionPane();
							message.showMessageDialog(null, "������ ���� ���� �ʽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
							//Main_Kiosk.c.success_Falg = 2;
							Main_Kiosk.c = null;
							break;
						}else if(Main_Kiosk.c.success_Falg== 1) {// ����
							JOptionPane message=new JOptionPane();
							message.showMessageDialog(null, "���������� ����Ǿ����ϴ�.");
							//Main_Kiosk.c.success_Falg = 2;
							con_Flag = true;
							break;
						}	
					}
				}
			}
		});
		add(chemist_Connect_Btn);
		start_Btn = new JButton("�����ϱ�");
		start_Btn.setBounds(0,0,200,100);
		start_Btn.setLocation(350,400);
		start_Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(open_Flag && con_Flag) {
					win.change("panel1");					
				}else {
					JOptionPane message=new JOptionPane();
					message.showMessageDialog(null, "��ĳ�� ���� �Ǵ� ������ ������ Ȯ���ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		add(start_Btn);
	}


}

class Frame_Kiosk extends JFrame {		//������ Ŭ����, �г��� ���� �ϴ� change�Լ�
	Jpanel0 jpanel00 = null;
	Jpanel1 jpanel01 = null;
	Jpanel2 jpanel02 = null;
	Jpanel3 jpanel03 = null;
	Jpanel4 jpanel04 = null;
	//	Jpanel5 jpanel05 = null;

	public void change(String panelName) { // �г� 1���� 2�� ���� �� �缳��
		if(panelName.equals("panel1")){
			getContentPane().removeAll();
			if(jpanel01 == null) {
				jpanel01 = new Jpanel1(this);
			}
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		} else if(panelName.equals("panel2")){
			getContentPane().removeAll();
			jpanel02 = new Jpanel2(this);
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		} else if (panelName.equals("panel3")){
			getContentPane().removeAll();
			jpanel03 = new Jpanel3(this);
			getContentPane().add(jpanel03);
			revalidate();
			repaint();
		}else if (panelName.equals("panel4")){
			getContentPane().removeAll();
			jpanel04 = new Jpanel4(this);
			getContentPane().add(jpanel04);
			revalidate();
			repaint();

		}
	}
}

public class Main_Kiosk {
	public static final int SCREEN_WIDTH = 1000; //����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;//���� �г�
	//	static JPanel page1 = new JPanel();
	public static Server_Kiosk s = null;
	public static Client_Kiosk c = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame_Kiosk win = new Frame_Kiosk();

		win.jpanel00 = new Jpanel0(win);
		win.addWindowListener(new MyWindowListener());
		win.add(win.jpanel00);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		win.setVisible(true);
	}
}
class MyWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������ ����");
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}