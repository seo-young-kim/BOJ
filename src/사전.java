import java.util.*;
import java.io.*;

public class 사전 {

	static long[][] comb;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//combination구하기
		comb = new long[N+M+1][N+M+1];
		comb(N+M);
		
		//K가 사전의 개수보다 적으면 
		if(comb[N+M][N]<K) {
			System.out.println(-1);
			return;
		}
		//K
		System.out.println(dp(N,M,K));
	}
	
	public static String dp(int N,int M,long K) {
		
		if(N==0 || M==0) {
			String str="";
			char c = (N==0)?'z':'a';
			int I = (N==0)?M:N;
			for(int i=0;i<I;i++)
				str = str+c;
			return str;
		}
		
		//a 로 시작하는거 개수 comb[N+M-1][N-1]
		if(comb[N+M-1][N-1]>=K)
			return 'a'+dp(N-1,M,K);
		else 
			return 'z'+dp(N,M-1,K-comb[N+M-1][N-1]);
		
	}
	
	
	public static void comb(int N) {
		
		for(int i=1;i<=N;i++) {
			comb[i][i]=1l;
			comb[i][0]=1;;}
		
		for(int i=2;i<=N;i++)
			for(int j=1;j<i;j++)
				comb[i][j]=comb[i-1][j-1]+comb[i-1][j];
	}
}