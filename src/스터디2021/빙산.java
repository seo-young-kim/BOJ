package 스터디2021;
import java.util.*;
import java.io.*;

public class 빙산 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//cnt= ice의 개수
		int ice=0;
		//지도
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0)
					ice++;
			}
		}
		//연수
		int year=0;
		
		while(true) {
			
			//다 녹았는데 분리되지 않음
			if(ice==0) {
				year=0;
				break;
			}
			//빙산이 2개 이상이면  true
			if(bfs(map,ice))
				break;
			
			//녹이고 남은 ice개수 리턴
			ice = melt(map);
			year++;
		}
		
		System.out.println(year);
		
	}
	public static int melt(int[][] map) {

		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int N = map.length; int M = map[0].length;
		
		int[][] add = new int[N][M];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				
				if(map[i][j]==0) continue;
				int cnt=0;
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
					if(map[nx][ny]==0) cnt++;
				}
				
				add[i][j]=cnt;
				
			}
		
		int ice=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				
				map[i][j]-=add[i][j];
				if(map[i][j]<0) map[i][j]=0;
				if(map[i][j]!=0) ice++;
		
			}
		
		return ice;
	}

	public static boolean bfs(int[][] map,int ice) {
		
		int N = map.length;
		int M = map[0].length;
			
		boolean[][] visit = new boolean[N][M];
		
		int cnt=0;
		Queue<int[]> que= new LinkedList<>();
outer:	for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) {
					que.offer(new int[] {i,j});
					cnt++;
					visit[i][j]=true;
					break outer;
				}
			}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = cur[0]+dx[k];
				int ny = cur[1]+dy[k];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny]) continue;
				
				if(map[nx][ny]!=0) {
					visit[nx][ny]=true;
					cnt++;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		if(cnt==ice) return false;
		
		return true;
	}
	
	
}
