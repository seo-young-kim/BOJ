import java.io.*;
import java.util.*;

public class 불켜기 {

	static boolean[][] light;
	static List[] map;
	static int cnt=0;
	static int not=0;
	static boolean[][] visit;
	static boolean[][] on;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new List[N*N];
		light = new boolean[N][N];
		visit = new boolean[N][N];
		on = new boolean[N][N];
		
		for(int i=0;i<N*N;i++)
			map[i]=new LinkedList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int index = r*N + c;
			map[x*N+y].add(index);
		}
		
		light[0][0]=true;
		cnt=1;
		visit[0][0]=true;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		
		int[] dx = {1,-1,0,0 };
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			//방문 안한거면
			if(!visit[x][y]) { 
				not--;
				visit[x][y]=true;
			}
		//	System.out.println("x="+x+" y="+y);
			//1.불키기
			if(on[x][y]) {
				
				Iterator itr = map[x*N+y].iterator();
				while(itr.hasNext()) {
					int swit = (Integer)itr.next();
					//스위치 존재
					int r = swit/N; int c = swit%N;
					if(!light[r][c]) {
						light[r][c]=true;
						cnt++;
						not++;
					}
				}
				on[x][y]=true;
			}
			if(not==0)
				break;
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0 || ny<0 || nx>=N || ny>=N || !light[nx][ny]) continue;
				que.offer(new int[] {nx,ny});
			}
		}
		
		System.out.println(cnt);
		
	}
}