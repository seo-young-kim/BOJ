package ���͵�2021;
import java.util.*;
import java.io.*;

public class �׷�ܾ�üĿ {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//�ܾ��
		int N = Integer.parseInt(bf.readLine());
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			
			boolean[] visit = new boolean[26];
			String word = bf.readLine();
			
			//�׷�ܾ� ����
			boolean check = true;
			
			char cur = word.charAt(0);
			visit[cur-'a']=true;
			
			for(int k=1;k<word.length();k++) {
				
				char next = word.charAt(k);
				if(next==cur) continue;
				
				if(visit[next-'a']) {
					check = false;
					break;
				}else {
					visit[next-'a']=true;
					cur = next;
				}
			}
			
			if(check)cnt++;
			System.out.println(word);
			
		}
		
		System.out.println(cnt);
		
	}

}
