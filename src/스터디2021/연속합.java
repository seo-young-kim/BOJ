package 스터디2021;
import java.io.*;
import java.util.*;
public class 연속합 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] dp= new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			dp[i]=Integer.parseInt(st.nextToken());
		
		int max = dp[0];
		for(int i=1;i<N;i++) {
			dp[i]=Math.max(dp[i], dp[i]+dp[i-1]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
		
	}

}
