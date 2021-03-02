package 스터디2021;
import java.util.*;
import java.io.*;

public class 잠수함식별 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		if(start(str)) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
		
	}
	public static boolean start(String str) {
		if(str.length()<2) {
			return false;
		}
	
		String next = str.substring(0, 2);
		if(next.equals("01")) {
			return state2(str.substring(2));
		}else if(next.equals("10")) {
			return state1(str.substring(2));
		}
			else return false;
	}
	public static boolean state1(String str) {
		System.out.println("state1 ; "+str);
		
		if(str.length()==0) return false;
		
		if(str.charAt(0)=='0')
			return state3(str.substring(1));
		
			return false;
	}

	public static boolean state2(String str) {
		
		System.out.println("state2 ; "+str);
		
		if(str.length()==0) 
			return true;
		
		if(str.length()<2) 
			return false;
		
		String next = str.substring(0, 2);
		
		if(next.equals("01"))
			return state2(str.substring(2));
		else if(next.contentEquals("10"))
			return state1(str.substring(2));
		else
			return false;
	}

	public static boolean state3(String str) {
		System.out.println("state3 ; "+str);
		
		if(str.length()<1) return false;
		
		if(str.charAt(0)=='0') {
			return state3(str.substring(1));
		}else
			return state4(str.substring(1));
	}

	public static boolean state4(String str) {
		
		if(str.length()==0) return true;
		
		int k=0;
		char next = str.charAt(k);
		
			
			while(next=='1') {
				k++;
				next=str.charAt(k);
				break;
			}
			return true;
		
		
	}

}
