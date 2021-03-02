package 스터디2021_2;
import java.io.*;
import java.util.*;

public class RGB거리2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[][] cost = new int[N][3];
		
			for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++)
				cost[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][3];
		
		int INF = 2000;
		int min = 987654321;
		
		for(int k=0;k<3;k++) {
			
			//dp[0][k]를 칠했을때
			for(int c=0;c<3;c++)
				dp[0][c]=(c==k)?cost[0][k]:INF;
			
			for(int r=1;r<N;r++) {
				dp[r][0]=Math.min(dp[r-1][1],dp[r-1][2])+cost[r][0];
				dp[r][1]=Math.min(dp[r-1][0],dp[r-1][2])+cost[r][1];
				dp[r][2]=Math.min(dp[r-1][0],dp[r-1][1])+cost[r][2];
			}
			
			for(int c=0;c<3;c++) {
				if(c!=k)
					min=Math.min(min,dp[N-1][c]);
			}
		}
		
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}

}
