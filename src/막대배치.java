import java.io.*;
import java.util.*;

public class 막대배치 {

	public static void main(String[] args) throws IOException{
		
		long[][][] dp = new long[21][21][21];
		
		dp[1][1][1]=1l;
		dp[2][2][1]=1l;
		dp[2][1][2]=1l;
		
		for(int n=3;n<21;n++) {
			for(int l=1;l<=n;l++) {
				for(int r=1;r<=n;r++) {
					dp[n][l][r]+=dp[n-1][l-1][r];
					dp[n][l][r]+=dp[n-1][l][r-1];
					dp[n][l][r]+=(n-2)*dp[n-1][l][r];
				}	
			}
		}
		
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while(T-->0) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			System.out.println(dp[N][L][R]);
		}
			
		
	}

}
