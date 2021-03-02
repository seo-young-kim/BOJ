package ���͵�2021_2;
import java.util.*;
import java.io.*;

public class ������ {

	static char[][] board;
	static int R,C,K;
	static String target;
	static int[][][] dp;
	static int L;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = bf.readLine();
			for(int j=0;j<C;j++)
				board[i][j]=str.charAt(j);
		}
		
		target = bf.readLine();
		L = target.length();
		
		dp = new int[R][C][L];
		for(int[][] e:dp)
			for(int[] arr:e)
				Arrays.fill(arr,-1);
		
		int answer = 0;
		
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++)
				//r,c���� target 0 ��° ���ڷ� Ž���� ���������� ����Ǽ�
				if(board[r][c]==target.charAt(0))
					answer += dfs(r,c,0);
		
		//target baeaka 
				
		System.out.println(answer);
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	// dp[2][][]
	//r,c���� ����ϴµ� target i��° ���ڷ� Ž���� ������ ������ ����� ��
	public static int dfs(int r,int c,int i) {
		
		//�̹� ������
		if(dp[r][c][i]>=0) return dp[r][c][i];
		
		//������ ���� ->1 return
		if(i==L-1) {
			dp[r][c][i]=1;
			return 1;
		}
			
		int sum=0;
		// break
		//������� k ��ŭ �������� Ž�� -> ������ sum+=����Ǽ�
		for(int d=0;d<4;d++) {
			int nx = r;
			int ny = c;
			for(int k=1;k<=K;k++) {
				nx+=dx[d];
				ny+=dy[d];
				
				if(nx<0 || ny<0 || nx>=R || ny>=C) break;
				
				if(board[nx][ny]==target.charAt(i+1))
					sum+=dfs(nx,ny,i+1);	
			}
		}
		
		dp[r][c][i]=sum;
		return dp[r][c][i];
		
	}
}