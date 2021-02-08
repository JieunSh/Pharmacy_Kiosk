import java.util.Scanner;
import java.util.Vector;

public class Translate {
	String info = null;
	String[] med_split = null;
	Vector<String> v1;
	int totalNum;			//접수번호
	public void input_Info(String tmp) {
		info = tmp;
		v1 = new Vector<>();
	}
	public void set_TotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public void split_Data() {
		String[] tmp = info.split("abc");
		//System.out.println(tmp[0]);
		String prescription = tmp[0]; // 처방전
		String tmp2 = tmp[1];
		
		//System.out.println(medicine_stat);

		String[] pre_split = prescription.split("/");
		String medicine_stat = pre_split[1]/*<<<< 접수번호*/+"/"+ tmp2; // 약국
		med_split = medicine_stat.split("/");
		for (int i = 0; i < pre_split.length; i++) {
			v1.add(pre_split[i]);
		}
		for (int j = 0; j < med_split.length; j++) {
			v1.add(med_split[j]);
		}
	}
	public void print_Vector() {
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
		}
	}
	public void clear_Vector() {
		v1.clear();
	}


}
