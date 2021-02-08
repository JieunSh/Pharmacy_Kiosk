
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIO {
	//파일 생성
	private static void CreatFile(String filePath) {
		try {
			System.out.println(filePath);
			int nLast = filePath.lastIndexOf("\\");
			String strDir =filePath.substring(0, nLast);
			String strFile = filePath.substring(nLast+1, filePath.length());
			
			File dirFolder = new File(strDir);
			dirFolder.mkdir();
			File f = new File(dirFolder, strFile);
			f.createNewFile();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	//파일 테스트 읽기
	private static String ReadFileText(File file) {
		String strText = "";
		int nBuffer;
		
		try {
//			BufferedReader bufread = new BufferedReader(new FileReader(file));
			BufferedReader bufread = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
			
			while((nBuffer = bufread.read())!= -1) {
				strText += (char)nBuffer;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return strText;
	}
	
	//파일 수정
	public void UpdateFile(String filePath, String Text) {
		try {
			File f = new File(filePath);
			if(f.exists() == false) {
				CreatFile(filePath);
			}
			String fileText = ReadFileText(f);
			//BufferedWriter buffWrite = new BufferedWriter(new FileWriter(f));
			BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "euc-kr"));
			Text = fileText + "\r\n" + Text;
			
			buffWrite.write(Text, 0, Text.length());
			buffWrite.flush();
			buffWrite.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	

}
