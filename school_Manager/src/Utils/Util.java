package Utils;

import java.util.Random;
import java.util.Scanner;

public class Util {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static Util instance = new Util();
	
	public static Util getInstance() {
		return instance;
	}
	
	public static void noDatamsg() {
		System.out.println("[ no student data ]");
	}
	
	public static int getRandValue() {
		Random rand = new Random();
		
		return rand.nextInt(51)+50;
	}
	
	public static String getStringValue(String msg) {
		System.out.print("▶ "+msg);
		String input = scan.next();
		scan.nextLine();
		
		return input;
	}
	
	public static int getValue(String msg, int start, int end) {
		while(true) {
			System.out.print("▶ "+msg);
			try{
				int input = scan.nextInt();
				if(input<start || input > end) {
					System.out.println("입력 범위 오류");
					continue;
				}
				return input;
			}catch(Exception e){
				System.out.println("정수 값 입력");
			}finally {
				scan.nextLine();
			}
		}
	}
	

}
