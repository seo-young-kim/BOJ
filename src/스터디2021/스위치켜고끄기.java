package 스터디2021;
import java.util.*;
import java.io.*;

public class 스위치켜고끄기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] swit = new int[N+1];
		
		for(int i=1;i<=N;i++)
			swit[i]=Integer.parseInt(st.nextToken());
		
		
		int M = Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(s==1) {
				int cnt=1;
				while(cnt*n<=N) {
					swit[cnt*n]=(swit[cnt*n]+1)%2;
					cnt++;
				}
			}else {
				
				int len=0;
				
				while(n-len>0 && n+len<=N && swit[n-len]==swit[n+len])
					len++;
				
				swit[n]=(swit[n]+1)%2;
				for(int l=1;l<len;l++) {
					swit[n-l]=(swit[n-l]+1)%2;
					swit[n+l]=(swit[n+l]+1)%2;
				}
				
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(swit[i]+" ");
			if(i%20==0)
				System.out.println();
		}
		
		
		

	}

}
