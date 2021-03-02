package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 문자열폭발 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String string = bf.readLine();
		String bomb = bf.readLine();
		
		char[] result = new char[string.length()];
		
		int idx=0;
		
		for(int i=0;i<string.length();i++) {
			result[idx]=string.charAt(i);
			
			if(isBomb(result,bomb,idx))
				idx-=bomb.length();
			idx++;
		}
		
		if(idx==0) {
			System.out.println("FRULA");
			return;
		}
		String answer=String.valueOf(result, 0, idx) ;
		for(int i=0;i<idx;i++)
			answer+=result[i];
		System.out.println(answer);
	}
	
	public static boolean isBomb(char[] result, String bomb,int idx) {
		
		if(idx<bomb.length()-1) return false;
		
		for(int i=0;i<bomb.length();i++)
			if(result[idx-i]!=bomb.charAt(bomb.length()-1-i)) return false;
		
		return true;
	}
}
