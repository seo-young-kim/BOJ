package ���͵�2021_2;
import java.util.*;
import java.io.*;

public class �պ��� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		final int INF = 1000000000;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//dp[k][n] := k�� ����ؼ� n �����
		int[][] dp = new int[K+1][N+1];
		Arrays.fill(dp[1],1);
		
		
		//sol2 (���� Ǯ��)
	    for(int k=2; k<=K; k++)
            for(int n=0; n<=N; n++)
            	//0~j���� k�� ��� j����� ����� ��
                dp[k][n] = (n==0) ? 1 : (dp[k-1][n] + dp[k][n-1]) % 1000000000;
            
		
		//�� ���� Ǯ��
		//1�� ����ؼ� �� ����°� ����� �� �Ѱ�����
		
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
