package 스터디2021_2;
import java.io.*;

public class 동물원 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[N+1];
		int[] odd = new int[N+1];
		
		dp[1]=3;
		odd[1]=1;
		
		int INF = 9901;
		
		for(int i=2;i<=N;i++) {
			dp[i]=(dp[i-1]+2*odd[i-1]+2)%INF;
			odd[i]=(dp[i-1]+odd[i-1])%INF;
		}
		
		System.out.println(dp[N]);
	}

}
