package 스터디2021;
import java.util.*;
import java.io.*;

public class 계단오르기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] step = new int[N+1];
		
		for(int i=1;i<=N;i++)
			step[i]=Integer.parseInt(bf.readLine());
		if(N==1) {
			System.out.println(step[1]);
			return;
		}
		if(N<=2) {
			System.out.println(step[1]+step[2]);
			return;
		}
		
		//dp [0] : 
		//dp [1] : 
		int[][] dp = new int[2][N+1];
		dp[0][1]=step[1];
		 for(int i=2;i<=N;i++) {
			dp[0][i]=Math.max(dp[0][i-2], dp[1][i-2])+step[i];
			dp[1][i]=dp[0][i-1]+step[i];
		}
		
		System.out.println(Math.max(dp[0][N], dp[1][N]));
		
	}

}
