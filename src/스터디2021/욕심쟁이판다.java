package ���͵�2021;
import java.io.*;
import java.util.*;

public class ��������Ǵ� {

	static int N;
	static int[][] dp;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		dp = new int[N][N];
	
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		
		
		//dp[i][j] := i,j���� �Ǵٰ� ���������� ��Ƴ��� �� �ִ� �ִ� �ϼ�
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				
				if(dp[i][j]==0) {
					dp(i,j);
					max = Math.max(max, dp[i][j]);
				}else
					max = Math.max(max, dp[i][j]);
			}
		
		System.out.println(max);
		
		
	}
	
	public static void dp(int i,int j) {
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int max = 0;
		
		for(int k=0;k<4;k++) {
			
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(map[i][j]>=map[nx][ny]) continue;
			
			
			//�̵��� �� �ִٸ� 
			if(dp[nx][ny]==0)
				dp(nx,ny);
			
			max = Math.max(max, dp[nx][ny]);
			
		}
		
		dp[i][j]=max+1;
		return;
		
	}

}
