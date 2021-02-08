
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class conn extends JPanel { // Ű����ũ�� ����(panel1)
	private Graphics screenGraphic;
	private Image screenImage;

	private ImageIcon connImage;
	public JButton btn_conn;

	private ImageIcon startImage;
	public JButton btn_start;

	private Image mainImage;
	private JLabel connect_label;
	private pharmacist_Kiosk p_k;

	public conn(pharmacist_Kiosk p_k) {					//ó��ȭ��
		this.p_k = p_k;
		connImage = new ImageIcon(this.getClass().getResource("image/conn_btn.png"));
		btn_conn = new JButton(connImage);
		startImage = new ImageIcon(this.getClass().getResource("image/start_btn.png"));
		btn_start = new JButton(startImage);
		mainImage = new ImageIcon(this.getClass().getResource("image/main.png")).getImage();
		connect_label = new JLabel("");
		setSize( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);
		btn_conn.setBounds(0,0, connImage.getIconWidth(), connImage.getIconHeight());
		btn_conn.setLocation(210,570);
		btn_conn.setBorderPainted(false);
		btn_conn.setContentAreaFilled(false);
		btn_conn.setFocusPainted(false);
		btn_conn.addActionListener(new MyActionListener());
		add(btn_conn);

		btn_start.setBounds(0,0, startImage.getIconWidth(), startImage.getIconHeight());
		btn_start.setLocation(450,570);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		btn_start.setFocusPainted(false);
		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane message=new JOptionPane();
				if(Server_Chemist.accept_Flag == false) {	//����

					message.showMessageDialog(null, "Ű����ũ�� ������� �ʾҽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
				}else										// ����
					message.showMessageDialog(null, "���������� ����Ǿ����ϴ�.");
				p_k.change("panel2");
			}

		});
		add(btn_start);


		connect_label.setBounds(10, 10, 100, 100);
		connect_label.setText("������");
		add(connect_label);
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(pharmacist_Kiosk.server == null) {
				pharmacist_Kiosk.server = new Server_Chemist(p_k);
			}
		}
	}

	public void paint(Graphics g) {
		screenImage = createImage( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(mainImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}

class conn_after extends JPanel { 						// ó�������? ��ǰ��Ȳ?
	private Graphics screenGraphic;
	private Image screenImage;

	private ImageIcon perscriptionImage;
	public JButton perscription_btn;
	private ImageIcon drugImage;
	public JButton drug_btn;
	private ImageIcon backImage;
	public JButton back_btn;

	private Image backgroundImage;

	private pharmacist_Kiosk p_k;

	public conn_after(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		perscriptionImage = new ImageIcon(this.getClass().getResource("image/perscription_btn.PNG"));
		perscription_btn = new JButton(perscriptionImage);
		drugImage = new ImageIcon(this.getClass().getResource("image/drug_btn.PNG"));
		drug_btn = new JButton(drugImage);
		backImage = new ImageIcon(this.getClass().getResource("image/back_btn.PNG"));
		back_btn= new JButton(backImage);
		backgroundImage = new ImageIcon(this.getClass().getResource("image/background.PNG")).getImage();
		setSize( Gui_Chemist.SCREEN_HEIGHT,  Gui_Chemist.SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);

		perscription_btn.setBounds(0, 0, perscriptionImage.getIconWidth(), perscriptionImage.getIconHeight());
		perscription_btn.setLocation(100, 200);
		perscription_btn.setBorderPainted(false);
		perscription_btn.setContentAreaFilled(false);
		perscription_btn.setFocusPainted(false);
		add(perscription_btn);


		drug_btn.setBounds(0, 0, drugImage.getIconWidth(), drugImage.getIconHeight());
		drug_btn.setLocation(500, 200);
		drug_btn.setBorderPainted(false);
		drug_btn.setContentAreaFilled(false);
		drug_btn.setFocusPainted(false);
		add(drug_btn);

		back_btn.setBounds(0, 0, backImage.getIconWidth(),backImage.getIconHeight());
		back_btn.setLocation(700, 600);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		add(back_btn);

		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel1");
			}

		});

		perscription_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				p_k.change("panel3");			//ó���� ��⸦ ������ Ű����ũ�� ���� ������ �ִٴ� �޽��� ����!

			}
		});
		drug_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4");
			}

		});
	}

	public void paint(Graphics g) {
		screenImage = createImage( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}


class medicine_loction extends JPanel { // panel3		ó���� ���� �����
	private Graphics screenGraphic;
	private Image screenImage;

	private ImageIcon labelImage;
	public JLabel str;
	private ImageIcon cancelImage;
	public JButton cancel_btn;
	private ImageIcon okImage;
	private Image backgroundImage;
	int choice;
	static JLabel persc_count;
	private pharmacist_Kiosk p_k;
	JButton ok_btn;
	JList list;
	DefaultListModel model;
	public medicine_loction(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		
		labelImage = new ImageIcon(this.getClass().getResource("image/label.PNG"));
		str= new JLabel(labelImage);
		cancelImage = new ImageIcon(this.getClass().getResource("image/cancel_btn.PNG"));
		cancel_btn = new JButton(cancelImage);
		okImage = new ImageIcon(this.getClass().getResource("image/ok_btn.PNG"));
		ok_btn = new JButton(okImage);
		backgroundImage = new ImageIcon(this.getClass().getResource("image/background.PNG")).getImage();
		persc_count = new JLabel("");
		setSize( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);
		//�Է� ���
		persc_count.setText("����");
		persc_count.setBounds(30, 30, 150, 50);
		persc_count.setFont(persc_count.getFont().deriveFont(50.0f));
		add(persc_count);

		str.setBounds(0,0, labelImage.getIconWidth(), labelImage.getIconHeight());		//���̺� �׸�
		str.setLocation(140, 250);
		add(str);

		cancel_btn.setBounds(0, 0, cancelImage.getIconWidth(), cancelImage.getIconHeight());
		cancel_btn.setLocation(300, 400);
		cancel_btn.setBorderPainted(false);
		cancel_btn.setContentAreaFilled(false);
		cancel_btn.setFocusPainted(false);
		add(cancel_btn);
		cancel_btn.addActionListener(new MyActionListener());
		String[] str_1 = {"�ȳ�", "�ȳ�", "�ȳ�", "�ȳ�"};
		list = new JList(new DefaultListModel());
		model = (DefaultListModel) list.getModel();
		
		list.setBounds(350, 30, 150, 200);
		model.addListDataListener(new ListDataListener() {
			
			@Override
			public void intervalRemoved(ListDataEvent e) {
				// TODO Auto-generated method stub
				System.out.println("removed");
				
			}
			
			@Override
			public void intervalAdded(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void contentsChanged(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(list);
		/*list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //�ϳ��� �����ϴ� ���� ����
	      list.addListSelectionListener(new ListSelectionListener() {
	         @Override
	         public void valueChanged(ListSelectionEvent e) {
	            // TODO Auto-generated method stub
	            JList src = (JList)e.getSource();
	            list.setSelectedIndex(choice);
	            System.out.println(choice);
	         }
	      });*/

		ok_btn.setBounds(0,0, okImage.getIconWidth(), okImage.getIconHeight());      //Ȯ�ι�ư �׸�
		ok_btn.setLocation(550, 80);
		ok_btn.setBorderPainted(false);
		ok_btn.setContentAreaFilled(false);
		ok_btn.setFocusPainted(false);
		
		ok_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choice = -1;					//�ʱ�ȭ
				choice = list.getSelectedIndex();
				System.out.println(choice);
				if(choice != -1) {		//���� �ƴٸ�
					System.out.println(model.elementAt(choice));
					String tmp[] = model.elementAt(choice).toString().split(":");
					Server_Chemist.pw.println("4/"+tmp[1]);	// tmp[1]�� �౹�� '������ȣ'
					model.removeElementAt(choice);	
				}
				
				
			}
		});
		add(ok_btn);
		Thread t = new Thread(pharmacist_Kiosk.server);
		t.start();	

	}

	class MyActionListener implements ActionListener {				//��ҹ�ư ������
		@Override
		public void actionPerformed(ActionEvent e) {
			Server_Chemist.stop_Flag= true;
			//			p_k.server.br= null;
			//			p_k.server.br = new BufferedReader(p_k.server.inputStreamReader);
			p_k.server.pw.println("3/not wait");
			System.out.println("not wait ����!");
			p_k.change("panel2");// ó���� ��� ��ưŬ���ϸ� ���� ȭ������ �̵�

		}
	}

	public void paint(Graphics g) {
		screenImage = createImage( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}

class durg_situ extends JPanel { // ���� ��Ȳ panel4
	private Graphics screenGraphic;
	private Image screenImage;
	private ImageIcon addImage;
	public JButton drug_add_btn;
	private ImageIcon countImage;
	public JButton durg_count_btn;
	private ImageIcon before_Image;
	public JButton before_persc;
	private Image backgroundImage;
	public JButton back_btn;
	private ImageIcon backImage;
	private pharmacist_Kiosk p_k;

	public durg_situ(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		addImage = new ImageIcon(this.getClass().getResource("image/add_btn.PNG"));
		drug_add_btn= new JButton(addImage);
		countImage = new ImageIcon(this.getClass().getResource("image/count_btn.PNG"));
		durg_count_btn = new JButton(countImage);
		before_Image = new ImageIcon(this.getClass().getResource("image/before_btn.PNG"));
		before_persc = new JButton(before_Image);
		backImage = new ImageIcon(this.getClass().getResource("image/back_btn.PNG"));
		back_btn= new JButton(backImage);
		backgroundImage = new ImageIcon(this.getClass().getResource("image/background.PNG")).getImage();

		setSize( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		setVisible(true);
		setLayout(null);

		drug_add_btn.setBounds(0, 0, addImage.getIconWidth(),addImage.getIconHeight());
		drug_add_btn.setLocation(330, 100);
		drug_add_btn.setBorderPainted(false);
		drug_add_btn.setContentAreaFilled(false);
		drug_add_btn.setFocusPainted(false);
		add(drug_add_btn);

		durg_count_btn.setBounds(0, 0, countImage.getIconWidth(),countImage.getIconHeight());
		durg_count_btn.setLocation(330, 300);
		durg_count_btn.setBorderPainted(false);
		durg_count_btn.setContentAreaFilled(false);
		durg_count_btn.setFocusPainted(false);
		add(durg_count_btn);

		before_persc.setBounds(0,0, before_Image.getIconWidth(),before_Image.getIconHeight());
		before_persc.setLocation(330, 500);
		before_persc.setBorderPainted(false);
		before_persc.setContentAreaFilled(false);
		before_persc.setFocusPainted(false);
		add(before_persc);

		back_btn.setBounds(0, 0, backImage.getIconWidth(),backImage.getIconHeight());
		back_btn.setLocation(700, 600);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		add(back_btn);

		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel2");
			}

		});
		drug_add_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4_1");
			}

		});
		durg_count_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4_2");
			}

		});
		before_persc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4_3");
			}

		});


	}

	public void paint(Graphics g) {
		screenImage = createImage( Gui_Chemist.SCREEN_WIDTH,  Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}

class durg_info_add extends JPanel { // ��ǰ�߰� panel4_1
	private Graphics screenGraphic;
	private Image screenImage;
	private ImageIcon add2Image;
	public JButton btn_add2;
	private ImageIcon backImage;
	public JButton back_btn;
	private Image backgroundImage;

	private pharmacist_Kiosk p_k;
	String filePath = "C:\\Users\\Seo\\Desktop\\drug_count.txt";
	Vector<String> v1 = new Vector<>();
	Vector<String> v2 = new Vector<>();
	String[] tmp;
	String[] drug_split = null;
	DefaultComboBoxModel model;
	private JComboBox comboBox;
	TextField textfield; // ���� �Է��ϴ� ��
	private JButton count_btn;
	String index;
	String buf = "";

	public durg_info_add(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		backgroundImage = new ImageIcon(this.getClass().getResource("image/add_page.PNG")).getImage();
		add2Image = new ImageIcon(this.getClass().getResource("image/add2_btn.PNG"));
		btn_add2= new JButton(add2Image);
		backImage = new ImageIcon(this.getClass().getResource("image/back_btn.PNG"));
		back_btn= new JButton(backImage);
		setLayout(null);

		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			String strText = null;
			while ((strText = read.readLine()) != null) {
				tmp = strText.split("/");
				String drug_num = tmp[0];
				v1.add(drug_num); //��ǰ�� ��ȣ
				v2.add(tmp[1]); //��ǰ�� ����
				buf += strText + "\n";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		String[] drug_num = v1.toArray(new String[] {});
		model = new DefaultComboBoxModel(drug_num);
		comboBox = new JComboBox(model);
		comboBox.setBounds(340, 270, 180, 50);
		add(comboBox);

		textfield = new TextField(); //���� �߰��Ҷ� �ʿ��� ����ϴ°� 
		textfield.setBounds(360, 420, 30, 30);
		add(textfield);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox box = (JComboBox) e.getSource();
				index = box.getSelectedItem().toString(); // �� ��ȣ
				int comnum = box.getSelectedIndex(); // �ε��� ������ ��
				//				System.out.println("i : " + index);
				//				System.out.println("c :" + comnum);
			}
		});	

		btn_add2.setBounds(0, 0, add2Image.getIconWidth(),add2Image.getIconHeight());
		btn_add2.setLocation(320, 500);
		btn_add2.setBorderPainted(false);
		btn_add2.setContentAreaFilled(false);
		btn_add2.setFocusPainted(false);
		add(btn_add2);

		back_btn.setBounds(0, 0, backImage.getIconWidth(),backImage.getIconHeight());
		back_btn.setLocation(700, 600);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		add(back_btn);

		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4");
			}

		});

		btn_add2.addActionListener(new ActionListener() { // ������ �Է��ϰ� Ȯ���� ������ ���Ͽ� �߰��Ǿ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buf = "";
				try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePath));
					for (int i = 0; i < v1.size(); i++) {
						if (index.equals(v1.get(i))) {
							v2.remove(i);
							v2.insertElementAt(textfield.getText(), i);
							//System.out.println(textfield.getText() + "");
						} else
							continue;
					}

					for(int i=0;i<v1.size();i++) {
						buf += v1.get(i) + "/" + v2.get(i) + "\r\n";

					}
					buffWrite.write(buf);
					buffWrite.flush();
					JOptionPane message=new JOptionPane();
					message.showMessageDialog(null, "���������� �����Ͽ����ϴ�.");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					JOptionPane message=new JOptionPane();
					message.showMessageDialog(null, "���濡 �����Ͽ����ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void paint(Graphics g) {
		screenImage = createImage(Gui_Chemist.SCREEN_WIDTH, Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}

class drug_info_count extends JPanel { // ��ǰ���� panel4_2
	private Graphics screenGraphic;
	private Image screenImage;

	private Image backgroundImage;
	private ImageIcon confirmImage;
	public JButton btn_confirm;
	
	private pharmacist_Kiosk p_k;

	String filePath = "C:\\Users\\Seo\\Desktop\\drug_count.txt";
	Vector<String> v1 = new Vector<>();
	Vector<String> v2 = new Vector<>();
	private String[] tmp = null;
	private String[] drug_split = null;
	DefaultComboBoxModel model;
	private JComboBox comboBox;
	private JLabel label_count;
	public JButton back_btn;
	private ImageIcon backImage;
	public drug_info_count(pharmacist_Kiosk p_k) {
		int i = 0;
		this.p_k = p_k;
		confirmImage = new ImageIcon(this.getClass().getResource("image/confirm_btn.PNG"));
		btn_confirm= new JButton(confirmImage);
		backImage = new ImageIcon(this.getClass().getResource("image/back_btn.PNG"));
		back_btn= new JButton(backImage);
		backgroundImage = new ImageIcon(this.getClass().getResource("image/count_page.PNG")).getImage();
		setLayout(null);

		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			String strText = null;
			while ((strText = read.readLine()) != null) {
				tmp = strText.split("/");
				System.out.println(Arrays.toString(tmp));
				v2.add(tmp[1]);
				String drug_num = tmp[0];
				v1.add(drug_num);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		String[] drug_num = v1.toArray(new String[] {}); // ���� ������ȣ, arraylist-> list�� ��ȯ / �޺��ڽ��� �ֱ����ؼ� �ʿ��ϴ�
		model = new DefaultComboBoxModel(drug_num);
		comboBox = new JComboBox(model);
		comboBox.setBounds(340, 270, 180, 50);
		add(comboBox);
		
		btn_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String index = comboBox.getSelectedItem().toString(); // �� ��ȣ
				int comnum = comboBox.getSelectedIndex(); // �ε��� ������ ��
				for (int i = 0; i < tmp.length; i++) {
					if (index == v1.get(comnum)) {
						label_count.setText(v2.get(comnum));
					}
				}
			}

		});
		
		btn_confirm.setBounds(0, 0, confirmImage.getIconWidth(),confirmImage.getIconHeight());
		btn_confirm.setLocation(320, 500);
		btn_confirm.setBorderPainted(false);
		btn_confirm.setContentAreaFilled(false);
		btn_confirm.setFocusPainted(false);
		add(btn_confirm);
		
		back_btn.setBounds(0, 0, backImage.getIconWidth(),backImage.getIconHeight());
		back_btn.setLocation(700, 600);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		add(back_btn);
		
		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4");
			}

		});
		
		label_count = new JLabel();
		label_count.setBounds(338, 395, 180, 50);
		label_count.setFont(new Font("�޸ո���T", Font.BOLD, 28));
		add(label_count);
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Gui_Chemist.SCREEN_WIDTH, Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}
}

class perscription_info extends JPanel { // �� ó���� ���� panel4_3
	private Graphics screenGraphic;
	private Image screenImage;
	private ImageIcon backImage;
	public JButton back_btn;
	private Image backgroundImage;
	JLabel[] pre_label = new JLabel[13];
	JLabel[] drug_label = new JLabel[45];
	private pharmacist_Kiosk p_k;
	TextField textfield;
	public JButton search_btn;
	public perscription_info(pharmacist_Kiosk p_k) {
		this.p_k = p_k;
		backgroundImage = new ImageIcon(this.getClass().getResource("image/prescription_page.PNG")).getImage();
		backImage = new ImageIcon(this.getClass().getResource("image/back_btn.PNG"));
		back_btn= new JButton(backImage);
		setLayout(null);
		
		textfield = new TextField(); // ���� �߰��Ҷ� �ʿ��� ����ϴ°�
		textfield.setBounds(62,31, 30, 30);
		add(textfield);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("MouseClicked("+e.getX()+","+e.getY()+")");
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		for(int i=0; i<13; i++) {
			pre_label[i] = new JLabel("");
		}
		for(int i=0; i<45; i++) {
			drug_label[i] = new JLabel("");
		}
		
//		pre_label[0].setText("1");			//������ȣ
//		pre_label[1].setText("2020");		//��
//		pre_label[2].setText("06");			//��
//		pre_label[3].setText("01");			//��
//		pre_label[4].setText("50091");		//ȣ��
//		pre_label[5].setText("���ϸ޵��÷����ǿ�");	
//		pre_label[6].setText("031-322-7582");
//		pre_label[7].setText("031-322-7583");
//		pre_label[8].setText("�����");
//		pre_label[9].setText("950506-1******");
//		pre_label[10].setText("�ȼ���");
//		pre_label[11].setText("�ǻ�");
//		pre_label[12].setText("60614");
//
//		
		pre_label[0].setBounds(769,107,30,30);
		pre_label[1].setBounds(321,109,30,30);
		pre_label[2].setBounds(391,110,30,30);
		pre_label[3].setBounds(454,109,30,30);
		pre_label[4].setBounds(572,107,100,30);
		pre_label[8].setBounds(371,142,200,30);
		pre_label[9].setBounds(371,181,200,30);
		pre_label[5].setBounds(371,211,200,30);
		pre_label[6].setBounds(371,243,200,30);
		pre_label[7].setBounds(371,276,200,30);
		pre_label[10].setBounds(236,317,100,30);
		pre_label[11].setBounds(533,303,50,30);
		pre_label[12].setBounds(590,340,100,30);
		for(int i =0; i<13; i++) {
			add(pre_label[i]);
		}
		int k = 0;
		for(int i = 0; i<9; i++) {
			drug_label[0+(k*5)].setBounds(173,430+(k*30),200,30);
			drug_label[1+(k*5)].setBounds(296,430+(k*30),400,30);
			drug_label[2+(k*5)].setBounds(576,430+(k*30),30,30);
			drug_label[3+(k*5)].setBounds(666,430+(k*30),30,30);
			drug_label[4+(k*5)].setBounds(753,430+(k*30),30,30);
			k++;
		}
		for(int i = 0; i<45; i++) {
			add(drug_label[i]);
		}
		
		search_btn = new JButton("��ȸ");
		search_btn.setBounds(43,85, 70,40 );
		add(search_btn);
		search_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Before_Prescription be = new Before_Prescription(p_k);
				//ó���� ���� 13��
				//�� ���� 45��
				for(int i = 0; i<13; i++) {		//ó���� ���� 
					pre_label[i].setText(be.result[i+1]); 
				}
				for(int i=0;i<45;i++) {			// �� ����
					if(be.result[i+14].equals("\\n")) {
						break;
					}
					drug_label[i].setText(be.result[i+14]);
				}
			}
		});
		back_btn.setBounds(0, 0, backImage.getIconWidth(),backImage.getIconHeight());
		back_btn.setLocation(14,182);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		add(back_btn);

		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p_k.change("panel4");
			}

		});
	}

	public void paint(Graphics g) {
		screenImage = createImage(Gui_Chemist.SCREEN_WIDTH, Gui_Chemist.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);// (0,0)��ġ�� screenImage����
	}

	private void screenDraw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backgroundImage, 0, 0, null);// �׸��� ���1
		paintComponents(g);// �׸��� ���2:�׻� �����Ǵ� ��, ��ư�̳� �޴���
		this.repaint();
	}

}


class pharmacist_Kiosk extends JFrame { // �����Լ�
	conn jpanel1 = null;
	conn_after jpanel2 = null;
	medicine_loction jpanel3 = null;
	durg_situ jpanel4 = null;
	durg_info_add jpanel4_1 = null;
	drug_info_count jpanel4_2 = null;
	perscription_info jpanel4_3 = null;
	static Server_Chemist server;
	public pharmacist_Kiosk() {

		// TODO Auto-generated constructor stub
		//	server = new Server_Chemist();
	}
	public void change(String panelName) {
		if (panelName.equals("panel1")) {
			getContentPane().removeAll();
			jpanel1 = new conn(this);
			getContentPane().add(jpanel1);
			revalidate();
			repaint();
		} else if (panelName.equals("panel2")) {
			getContentPane().removeAll();
			jpanel2 = new conn_after(this);
			getContentPane().add(jpanel2);
			revalidate();
			repaint();
		} else if (panelName.equals("panel3")) {
			getContentPane().removeAll();
			jpanel3 = new medicine_loction(this);
			getContentPane().add(jpanel3);
			revalidate();
			repaint();

		} else if (panelName.equals("panel4")) {
			getContentPane().removeAll();
			jpanel4 = new durg_situ(this);
			getContentPane().add(jpanel4);
			revalidate();
			repaint();
		} else if (panelName.equals("panel4_1")) {
			getContentPane().removeAll();
			jpanel4_1 = new durg_info_add(this);
			getContentPane().add(jpanel4_1);
			revalidate();
			repaint();
		} else if (panelName.equals("panel4_2")) {
			getContentPane().removeAll();
			jpanel4_2 = new drug_info_count(this);
			getContentPane().add(jpanel4_2);
			revalidate();
			repaint();
		} else if (panelName.equals("panel4_3")) {
			getContentPane().removeAll();
			jpanel4_3 = new perscription_info(this);
			getContentPane().add(jpanel4_3);
			revalidate();
			repaint();
		}
	}
}

public class  Gui_Chemist {
	public static final int SCREEN_WIDTH = 1000; // ����� ���� �빮��
	public static final int SCREEN_HEIGHT = 800;// ���� �г�

	public Gui_Chemist() {

		// TODO Auto-generated method stub
		pharmacist_Kiosk p_k = new pharmacist_Kiosk();
		p_k.jpanel1 = new conn(p_k);
		p_k.add(p_k.jpanel1);
		p_k.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		p_k.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		p_k.setVisible(true);
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