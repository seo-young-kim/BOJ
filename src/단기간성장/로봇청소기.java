package 단기간성장;
import java.util.*;
import java.io.*;

public class 로봇청소기 {

	static int[][] map;
	static int N,M;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		min = 987654321;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		if(N==0 && M==0) break;
		
		map = new int[N][M];
		
		int cnt=2;
		
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<M;j++) {
				char next = str.charAt(j);
				switch(next) {
				case '.' :  map[i][j]=0; break;
				case 'x' :	map[i][j]=-1; break;
				case 'o' :	map[i][j]=1; break;
				case '*' :  map[i][j]=cnt++; break;
				}
			}
		}
		
		dist = new int[cnt][cnt];
		for(int[] e:dist)
			Arrays.fill(e, -1);
		for(int i=1;i<cnt;i++)
			dist[i][i]=0;
		//dist 채우기
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]>0)
					bfs(i,j);
		
		//for(int[] e:dist)
			//System.out.println(Arrays.toString(e));
		C = cnt-1;
		//dist를 이용해 1부터 시작 모든 노드를 방문하는 경로의 최소값을 구한다
		boolean[] v = new boolean[cnt];
		v[1]=true;
		dfs(1,1,v,0);
		if(min==987654321)
			min=-1;
		System.out.println(min);
		}
		
	}
	static int C;
	public static void dfs(int s,int cnt,boolean[] visit,int sum) {
		
		if(cnt>=C) {
			min = Math.min(min, sum);
			return;
		}
			
		
		for(int i=2;i<=C;i++) {
			if(!visit[i] && dist[s][i]>0) {
				visit[i]=true;
				dfs(i,cnt+1,visit,sum+dist[s][i]);
				visit[i]=false;
			}
		}
		
		
	}
	static int min;
	
	public static void bfs(int i,int j) {
		
		//-1이면 미방문, 아니면 i,j로부터의 거리
		int[][] visited = new int[N][M];
		for(int[] e:visited)
			Arrays.fill(e, -1);
		visited[i][j] = 0;
		//
		int node = map[i][j];
		
		//dist[node] 채우면 됨
		Queue<int[]> que= new LinkedList<>();
		que.offer(new int[] {i,j});
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				//-1이면 못지나가는곳
				if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==-1) continue;
				//방문안된곳이면 방문
				if(visited[nx][ny]==-1) {
					visited[nx][ny]=visited[x][y]+1;
					que.offer(new int[] {nx,ny});
					//만약 뭐 있는데면 거리 업데이트
					if(map[nx][ny]>0)
						dist[node][map[nx][ny]]=visited[nx][ny];
				}
			}
		}
		
	}
	

}
