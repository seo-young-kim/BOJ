package 단기간성장;
import java.io.*;

public class 색상환 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int K = Integer.parseInt(bf.readLine());
		final int INF = 1000000003;
		
		int[][] dp = new int[N][K+1];
		
		for(int i=0;i<N;i++)
			dp[i][0]=1;
		
		for(int i=1;i<N;i++)
			dp[i][1]=i;
			
		for(int n=3;n<N;n++)
			for(int k=2;k<=K;k++) {
				if(n<=k) continue;
				dp[n][k]=dp[n-1][k]+dp[n-2][k-1];
			}
		
		int ans = 0;
			//맨 앞을 선택 안한경우/ 선택한경우
		ans+=dp[N-1][K]+dp[N-3][K-1];
		ans%=INF;
		System.out.println(ans);
		
	}
}