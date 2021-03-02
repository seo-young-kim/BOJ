package 스터디2021_2;
import java.io.*;
public class 타일채우기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] dp = new int[N+1];
		dp[0]=1;
		for(int n=2;n<=N;n+=2) {
			dp[n] = 3*dp[n-2];
			for(int k=4;k<=n;k+=2)
				dp[n]+=2*dp[n-k];
		}
		System.out.println(dp[N]);
	}
}