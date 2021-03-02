import java.util.*;
import java.io.*;

public class 가르침 {

	static int N,K;
	static String[] word;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int exist = 0;
		word = new String[N];
		
		for(int i=0;i<N;i++) {
			word[i] = bf.readLine();
			for(int j=0;j<word[i].length();j++) {
				int next = word[i].charAt(j)-'a';
				exist |=(1<<next);
			}
		}
		
		
		int count=0;
		for(int i=0;i<26;i++)
			if((exist & (1<<i))!=0) 
				count++;
		
		//다 가르칠 수 있음
		if(count<=K) {
			System.out.println(N);
			return;
		}
		
		//선택집합
		int S=0;
		char[] p = {'a','n','t','i','c'};
		//1. a,n,t,i,c 
		for(int k=0;k<5;k++) {
			int i = p[k]-'a';
			exist &= ~(1<<i);
			S |=(1<<i);
		}
		
		//2. backtracking
		bt(0,5,S,exist);
		
		System.out.println(max);
		
	}
	
	static int max=0;
						//선택한 개수 , 선택한 원소, 남은 원소
	public static void bt(int k,int cnt, int S,int ex) {
		
		
		if(cnt==K) {
			int poss=0;
				
	outer:	for(int i=0;i<N;i++) {
				for(int j=4;j<word[i].length()-4;j++) {
					int next = word[i].charAt(j)-'a';
					if((S&(1<<next))==0)
						continue outer;
				}
				poss++;
			}
			
			max = Math.max(max, poss);
			return;
		}
		
		for(int i=k;i<26;i++) {
			if((ex&(1<<i))==0) 
				continue;
			ex |=(1<<i);
			bt(i+1,cnt+1,S|(1<<i),ex);
			ex &=~(1<<i);
		}
		
	}

}
