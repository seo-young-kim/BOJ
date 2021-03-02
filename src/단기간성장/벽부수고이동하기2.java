package 단기간성장;
import java.util.*;
import java.io.*;

public class 벽부수고이동하기2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][][] visit = new int[N][M][K+1];
		
		int[][] wall = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<M;j++)
				wall[i][j]=str.charAt(j)-'0';
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0,0});
		visit[0][0][0]=1;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0]; int y = cur[1]; int w = cur[2];
			
			for(int k=0;k<4;k++) {
				
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				
				//벽 없음 그럼 그냥 안갔으면 가면 됨
				if(wall[nx][ny]==0) {
					
					if(visit[nx][ny][w]!=0) continue;
					
					visit[nx][ny][w]=visit[x][y][w]+1;
					que.offer(new int[] {nx,ny,w});
					
				//벽 있으면 뚫고 갈수 있으면 가면 됨.
				//만약 뚫었을떄 이미 존재하면 안가도 됨
				}else {
					if(w<K) {
						if(visit[nx][ny][w+1]!=0) continue;

						visit[nx][ny][w+1]=visit[x][y][w]+1;
						que.offer(new int[] {nx,ny,w+1});
							
					}
				}
			}
			
		}
		
		
		
		int min=987654321;
		for(int w=0;w<=K;w++)
			if(visit[N-1][M-1][w]!=0)
				min = Math.min(min, visit[N-1][M-1][w]);
		
		if(min==987654321)
			min=-1;
		System.out.println(min);
		
		
		
	}

}
