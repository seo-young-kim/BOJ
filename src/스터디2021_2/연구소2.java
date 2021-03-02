package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 연구소2 {

	static int N;
	static int[][] map;
	static int min = 987654321;
	static boolean[] check;
	static int[][] seat;
	static int C;
	static int wall;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		C=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					C++;
				if(map[i][j]==1)
					wall++;
			}
		}
		
		seat = new int[C][2];
		check = new boolean[C];
		int index=0;
		for(int i=0;i<N*N;i++)
			if(map[i/N][i%N]==2) {
				seat[index][0]=i/N;
				seat[index][1]=i%N;
				index++;
			}
		
		bt(0,M);
		if(min==987654321)
			min=-1;
		System.out.println(min);
			
	}
	
	public static void bt(int s,int cnt) {
		
		if(cnt==0) {
			bfs();
			return;
		}
		
		for(int i=s;i<C;i++)
			if(!check[i]) {
				check[i]=true;
				bt(i+1,cnt-1);
				check[i]=false;
			}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void bfs() {
		
		boolean[][] visit = new boolean[N][N];
		int total=0;
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<C;i++)
			if(check[i]) {
				que.offer(seat[i]);
				visit[seat[i][0]][seat[i][1]]=true;
				total++;
			}
		
		int time=-1;
		while(!que.isEmpty()) {
			time++;
			int SIZE = que.size(); 
			while(SIZE-->0) {
				
				int[] cur = que.poll();
				int x = cur[0];
				int y = cur[1];
				
				for(int k=0;k<4;k++) {
					int nx=x+dx[k];
					int ny=y+dy[k];
					if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;
					if(visit[nx][ny] || map[nx][ny]==1) continue;
					visit[nx][ny]=true;
					total++;
					que.offer(new int[] {nx,ny});
				}
				
			}
		}
		
		if(total+wall<N*N)
			return;
		
		min = Math.min(min,time);
		
	}
}