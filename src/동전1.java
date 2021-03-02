import java.util.*;
import java.io.*;

public class 동전1 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int C = Integer.parseInt(st.nextToken());
		
		//원하는 가격
		int M = Integer.parseInt(st.nextToken());
		
		//동전 가격 1 2 5
 		int[] coin = new int[C+1];
		for(int i=1;i<=C;i++)
			coin[i]=Integer.parseInt(bf.readLine());
		
		//
		int[][] dp = new int[C+1][M+1];
		
		for(int i=1;i<=C;i++) {
			int c = coin[i];
			dp[i][0]=1;
			for(int m=1;m<=M;m++)
				if(c>m)
					dp[i][m] = dp[i-1][m];
				else
					dp[i][m] = dp[i][m-c]+dp[i-1][m];
		}
		
		for(int[] e:dp)
			System.out.println(Arrays.toString(e));
		System.out.println(dp[C][M]);
	}

}
