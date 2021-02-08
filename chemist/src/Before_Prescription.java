import java.awt.TextField;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Before_Prescription extends JPanel {
	String filePath = "C:\\Users\\Seo\\Desktop\\test.txt";
	
	String[] result;

	private JLabel str1;
	private TextField textfield;

	public Before_Prescription(pharmacist_Kiosk p_k) {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "euc-kr"));
			String strText = null;
			strText = read.readLine();
			while ((strText = read.readLine()) != null) {
				String[] tmp = strText.split("abc");
				String prescription = tmp[0];
				String drug = tmp[1];
				result = (prescription +"/"+ drug).split("/");
				System.out.println(Arrays.toString(result));
				
				if(result[1].equals(p_k.jpanel4_3.textfield.getText())) //∞∞¿∏∏È ≈ª√‚
					break;
			}
			/*for(int i=1;i<(p_k.jpanel4_3.label.length)+1;i++) {
				p_k.jpanel4_3.label[i].setText(result[i]);
				System.out.println(result[i]);
			}*/
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

