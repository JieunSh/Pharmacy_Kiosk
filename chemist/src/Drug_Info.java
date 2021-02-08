import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Drug_Info {
	Vector<String> v1;
	Vector<String> v2;
	Vector<String> v3;
	Translate trans;
	JButton confirm;

	String filePath = "C:\\Users\\Seo\\Desktop\\durg_info_1.txt";
	
	String[] tmp;
	String drug_name; //약의 이름
	String durg_poistion; // 약의 위치
	
	String info;

	public Drug_Info(String tmp) {
		// TODO Auto-generated constructor stub
		this.info = tmp;
		trans = new Translate();
		v1 = new Vector<>();
		v2 = new Vector<>(); //약의 이름 
		v3 = new Vector<>(); // 약의 위치 지정할 벡터
	}
	
	public void print_info() {
		trans.input_Info(info);
		trans.split_Data();

		// 파일 읽어오는 부분
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			String strText = null;
			while ((strText = read.readLine()) != null) {
				tmp = strText.split("/");
				String drug_num = tmp[0];
				String drug_name = tmp[1]; //약의 이름
				durg_poistion = tmp[2] + ", " + tmp[3];
				v1.add(drug_num); // 약품의 번호
				v2.add(drug_name);
				v3.add(durg_poistion);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

		for (int i = 0; i < v1.size(); i++) { // v1이 durg_info의 643306670
			for (int j = 0; j < trans.med_split.length; j++) {
				if (v1.get(i).equals(trans.med_split[j])) {
					JOptionPane message = new JOptionPane();
					message.showMessageDialog(null, "약의 이름은 " + v2.get(i) + " 약의 위치는 " + v3.get(i) + "입니다.");
				}
			}
		}
		JOptionPane message = new JOptionPane();
		message.showMessageDialog(null, "접수번호 "+ trans.med_split[0] + ",님의 약의 제조가 완료되었습니다.");
		
		
	}
	
}
