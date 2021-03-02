package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 합분해 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		final int INF = 1000000000;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//dp[k][n] := k개 사용해서 n 만들기
		int[][] dp = new int[K+1][N+1];
		Arrays.fill(dp[1],1);
		
		
		//sol2 (남의 풀이)
	    for(int k=2; k<=K; k++)
            for(int n=0; n<=N; n++)
            	//0~j에서 k개 골라서 j만드는 경우의 수
                dp[k][n] = (n==0) ? 1 : (dp[k-1][n] + dp[k][n-1]) % 1000000000;
            
		
		//내 원래 풀이
		//1개 사용해서 뭐 만드는거 경우의 수 한가지임
		
		for(int k=2;k<=K;k++)
			for(int n=0;n<=N;n++) {
				//dp[k][n] = 0<=i<=n sum(dp[k-1][n-i])
				long sum=0l;
				for(int i=0;i<=n;i++) {
					sum+=(long)dp[k-1][n-i];
					sum%=INF;
				}
				dp[k][n]=(int)sum;
			}
		
		System.out.println(dp[K][N]);
		
	}

}
