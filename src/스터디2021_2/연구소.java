package 스터디2021_2;
import java.util.*;
import java.io.*;
public class 연구소 {

	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		bt(0,0);
		System.out.print(max);
	}
	
	public static void bt(int s,int cnt) {
		
		if(cnt==3) {
			bfs();
			return;
		}
		
		for(int i=s;i<N*M;i++) {
			int x = i/M;
			int y = i%M;
			if(map[x][y]==0) { 
				map[x][y]=1;
				bt(s+1,cnt+1);
				map[x][y]=0;
			}
		}
	}
	static int max=0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void bfs() {
		
		Queue<int[]> que = new LinkedList<>();
		
		boolean[][] visit = new boolean[N][M];
		
		for(int i=0;i<N*M;i++)
			if(map[i/M][i%M]==2) {
				que.offer(new int[] {i/M,i%M});
				visit[i/M][i%M]=true;
			}
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			for(int k=0;k<4;k++) {
				int nx = cur[0]+dx[k];
				int ny = cur[1]+dy[k];
				if(nx< 0 || ny<0 || nx>=N || ny>=M) continue;
				if(!visit[nx][ny] && map[nx][ny]==0) {
					visit[nx][ny]=true;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		int sum=0;
		for(int i=0;i<N*M;i++)
			if(!visit[i/M][i%M] && map[i/M][i%M]==0) sum++;
		
		max = Math.max(max,sum);
		
	}

}
