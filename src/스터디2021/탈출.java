package 스터디2021;
import java.util.*;
import java.io.*;

public class 탈출 {

	static int R,C;
	static char[][] map;
	static int[][] water;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C]; water = new int[R][C];
		
		Queue<int[]> que = new LinkedList<>();
		
		//water 배열 -1로 초기화 
		for(int[] e:water)
			Arrays.fill(e, -1);
		
		//고슴도치 위치
		int sx=-1,sy=-1;
		
		//입력받기
		for(int i=0;i<R;i++) {
			String str = bf.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				//물이면 큐에 넣고 거기는 0
				if(map[i][j]=='*') {
					que.offer(new int[] {i,j});
					water[i][j] = 0;
				}
				if(map[i][j]=='S') {
					sx = i; sy=j; }
			}
		}
		
		//1. water채우기
		fillmap(que);
		
		//2. 고슴도치 이동하기
		int time = move(sx,sy);
		
		if(time==-1)
			System.out.println("KAKTUS");
		else
			System.out.println(time);
		
	}
	
	
	public static int move(int sx,int sy) {
	
		int[][] visit = new int[R][C];
		for(int[] e:visit)
			Arrays.fill(e,-1);
		visit[sx][sy]=0;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sx,sy});
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int cx = cur[0]; int cy = cur[1];
			int time = visit[cx][cy];
			
			for(int k=0;k<4;k++) {
				
				 int nx = cx + dx[k];
				 int ny = cy + dy[k];
				 
				 if(nx<0 || ny<0 || nx>=R || ny>=C) continue; 
				 //이미 온길
				 if(visit[nx][ny]!=-1) continue;
				 
				 //돌이면 못감
				 if(map[nx][ny]=='X') continue;
				 //구멍!!
				 if(map[nx][ny]=='D') {return time+1;}
				 
				 //이미 물이 왔으면 못감 (water[nx][ny]==-1이면 물이 애초에 없었음)
				 if(water[nx][ny]!=-1 && water[nx][ny]<=time+1) continue;
					 
				 que.offer(new int[] {nx,ny});
				 visit[nx][ny]=time+1;
			}
		}
		
		
		return -1;
	}
	
	public static void fillmap(Queue<int[]> que) {
		
		int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int cx = cur[0]; int cy = cur[1];
			int time = water[cx][cy];
			
			for(int k=0;k<4;k++) {
				
				int nx = cx+dx[k];
				int ny = cy+dy[k];
				
				if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
				if(water[nx][ny]!=-1) continue;
				if(map[nx][ny]=='D' || map[nx][ny]=='X') continue;
				
				water[nx][ny]=time+1;
				que.offer(new int[] {nx,ny});
			}
		}
	}
		
}
