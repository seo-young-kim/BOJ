package 스터디2021_2;
import java.io.*;

public class _123더하기3 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		final int INF = 1000000009;
		
		int[] dp = new int[1000001];
		
		dp[1]=1; dp[2]=2; dp[3]=4;
		dp[4]=7;
		int sum=7;
		
		//dp[7] 
		// 1 +  합이 6이 되게 하는 경우의 수
		// 2 + 
		// 3 + 
		
		for(int i=5;i<=1000000;i++) {
			//sum = dp[i-4]+dp[i-3]+dp[i-2];
			//dp[i] =dp[i-3]+dp[i-2]+ dp[i-1]
			//dp[i] = sum-dp[i-4]+dp[i-1];
			sum = (sum-dp[i-4]+dp[i-1])%INF;
			dp[i]=sum;
		}
		
		
		for(int i=5;i<=1000000;i++) {
			dp[i]=(((dp[i-3]+dp[i-2])%INF)+ dp[i-1])%INF;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t=0;t<Tc;t++) {
			int next = Integer.parseInt(bf.readLine());
			bw.write(dp[next]+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
