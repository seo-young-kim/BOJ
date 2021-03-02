package 단기간성장;
import java.util.*;
import java.io.*;

public class 벽부수고이동하기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<M;j++)
				map[i][j]=str.charAt(j)-'0';
		}
		
		int[][][] visit = new int[2][N][M];
		
		visit[0][0][0]=1;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0,0});
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0]; int y = cur[1];
			int w = cur[2];
			int dp = visit[w][x][y];
			
			for(int k=0;k<4;k++) {
				
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				//벽이 없는 경우
				if(map[nx][ny]==0) {
					//아직 방문 안했으면 간다. ( w==1일때 쓸데 없이 더 하겠지만 결과에는 영향이 없을듯 )
					if(visit[w][nx][ny]==0) {
						visit[w][nx][ny]=dp+1;
						que.offer(new int[] {nx,ny,w});
					}
				}else {//벽이 있는 경우
					if(w==1) continue;
					
					if(visit[1][nx][ny]==0) {
						visit[1][nx][ny]=dp+1;
						que.offer(new int[] {nx,ny,1});
					}
				}
				
			}
		}
		
		//0이 아닌 값 중 가장 작은 값 구하고 싶음
		int min=987654321;
		for(int w=0;w<=1;w++)
			if(visit[w][N-1][M-1]!=0)
				min = Math.min(min, visit[w][N-1][M-1]);
		
		if(min==987654321)
			min=-1;
		System.out.println(min);
		
	}

}
