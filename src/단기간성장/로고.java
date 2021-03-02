package 단기간성장;
import java.util.*;
import java.io.*;

public class 로고 {
	static boolean[][] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		map = new int[1001][1001];
		visited = new boolean[1001][1001];
		
			//0 1 2 3   1 0 3 2
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int[][] dir = {{0,1,2,3},{1,0,3,2}};
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken())+500;
			int y1 = Integer.parseInt(st.nextToken())+500;
			int x2 = Integer.parseInt(st.nextToken())+500;
			int y2 = Integer.parseInt(st.nextToken())+500;
			
			//1->2 시계&반시계
			for(int index=0;index<=1;index++) {
				int x = x1; int y=y1;
				for(int k=0;k<4;k++) {
					int nx = x+dx[dir[index][k]]; int ny = y+dy[dir[index][k]];
					while(nx>=x1 && nx<=x2 && ny>=y1 && ny<=y2) {
						map[x][y]|=(1<<(dir[index][k]));
						x=nx; y=ny;
						nx += dx[dir[index][k]]; ny += dy[dir[index][k]];
					}
				}
			}
		}
		
		int cnt=0;
		
		for(int x=0;x<=1000;x++)
			for(int y=0;y<=1000;y++)
				if(map[x][y]!=0 && !visited[x][y]) {
					bfs(x,y);
					cnt++;
				}
			
		
		if(map[500][500]!=0)
			cnt--;
		
		System.out.println(cnt);
		
	}
	public static void bfs(int sx,int sy) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sx,sy});
		visited[sx][sy]=true;
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for(int k=0;k<4;k++)
				if((map[x][y]&(1<<k))!=0) {
					int nx = x+dx[k];
					int ny = y+dy[k];
					if(!visited[nx][ny]) {
						visited[nx][ny]=true;
						que.offer(new int[] {nx,ny});
					}
				}	
		}
		
	}
	

}