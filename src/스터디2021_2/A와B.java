package 스터디2021_2;
import java.io.*;
import java.util.*;

public class A와B {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String S = bf.readLine();
		
		StringBuilder T = new StringBuilder(bf.readLine());
		
		while(T.length()>S.length()) {
			
			if(T.charAt(T.length()-1)=='A') {
				T.deleteCharAt(T.length()-1);
			}else {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		if(S.equals(T.toString())) {
			System.out.println("1");
		}else {
			System.out.println("1");
		}
		
		
	}
}