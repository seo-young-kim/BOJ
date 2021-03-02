package 스터디2021;
import java.util.*;
import java.io.*;

public class 가르침 {

	static String[] words;
	static int max=0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K<5) {
			System.out.println(0);
			System.exit(0);
		}
		
		words = new String[N];
		
		for(int i=0;i<N;i++)
			words[i]=bf.readLine();
		
		boolean[] alpa = new boolean[26];
		
		alpa['a'-'a']=true;
		alpa['n'-'a']=true;
		alpa['t'-'a']=true;
		alpa['i'-'a']=true;
		alpa['c'-'a']=true;
		
		bt(0,alpa,K-5);
		
		System.out.println(max);
		
	}
	
	public static int count(boolean[] alpa) {
		
		int cnt=0;
		int N = words.length;
		for(int i=0;i<N;i++) {
			
			boolean flag = true;
			int len = words[i].length();
			for(int j=4;j<len-4;j++) {
				char word = words[i].charAt(j);
				if(!alpa[word-'a']) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				cnt++;
		}
		
		return cnt;
	}
	public static void bt(int s, boolean[] alpa,int K) {
		
		if(K==0) {
			max = Math.max(max,count(alpa));
			return;
		}
		
		for(int i=s;i<26;i++) {
			if(!alpa[i]) {
				alpa[i]=true;
				bt(s+1,alpa,K-1);
				alpa[i]=false;
			}
		}
	}

}
