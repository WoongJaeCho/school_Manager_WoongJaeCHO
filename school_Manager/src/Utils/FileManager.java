package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import DAO.StudentDAO;
import DAO.SubjectDAO;

public class FileManager {
	
	private final String CUR_PATH = System.getProperty("user.dir")+"\\src\\"+new Util().getClass().getPackageName()+"\\";
	//private static final String CUR_PATH = System.getProperty("user.dir")+"/src/"+new Util().getClass().getPackageName()+"/";
	
	private void saveToFileData(String fileName, String data) {
		try(FileWriter fw = new FileWriter(CUR_PATH + fileName)){
			fw.write(data);
			System.out.println(fileName+"파일 저장 성공");
		} catch (IOException e) {
			System.out.println(fileName+"파일 저장 실패");
		}
	}
	
	public void saveToFile(StudentDAO stuDAO, SubjectDAO subDAO) {
		String stuData = stuDAO.saveToData();
		String subData = subDAO.saveToData();
		saveToFileData("student.txt", stuData);
		saveToFileData("subject.txt", subData);
	}
	
	private String loadToFileData(String fileName) {
		try(FileReader fr = new FileReader(CUR_PATH + fileName);
				BufferedReader br = new BufferedReader(fr);){
			String data="";
			while(true) {
				int read = br.read();
				if(read == -1) break;
				
				data += (char)read;
			}
			System.out.println(fileName+"파일 로드 성공");
			return data;
		} catch (IOException e) {
			System.out.println(fileName+"파일 로드 실패");
			return null;
		}
	}
	
	public void loadToFile(StudentDAO stuDAO, SubjectDAO subDAO) {
		String studata = loadToFileData("student.txt");
		String subdata = loadToFileData("subject.txt");
		stuDAO.loadToData(studata);
		subDAO.loadToData(subdata);
		stuDAO.updataMaxNo();
	}
}
