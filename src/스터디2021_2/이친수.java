package 스터디2021_2;
import java.io.*;

public class 이친수 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		if(N<=2) {
			System.out.println(1); return;
		}
		
		long[] dp = new long[N];
		dp[0]=1l;
		dp[1]=1l;
		for(int i=2;i<N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N-1]);
	}

}
