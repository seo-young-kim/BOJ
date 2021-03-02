package 스터디2021;
import java.util.*;
import java.io.*;

public class IcePerimeter {

	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String next = bf.readLine();
			for(int j=0;j<N;j++)
				if(next.charAt(j)=='#')
					map[i][j]=0;
				else
					map[i][j]=-1;
		}
		
		int maxArea = 0;
		int minPeri = 987654321;
		int cnt=1;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(map[i][j]==0) {
					int[] info = bfs(i,j,cnt);
					cnt++;
					if(maxArea<info[0]) {
						maxArea = info[0];
						minPeri = info[1];
					}
					if(maxArea==info[0]) {
						minPeri = Math.min(minPeri, info[1]);
					}
					
	//				print();
				}
		
		System.out.println(maxArea+" "+minPeri);
		
	}
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[] bfs(int x,int y,int cnt) {
		
		
		//큐에 넣으면서 map바꾸기& area카운트하기
		//큐에서 빼면서 perimeter세기
		int meter=0;
		int area=1;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {x,y});
		map[x][y]=cnt;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			
			for(int k=0;k<4;k++) {
				
				int nx = cur[0]+dx[k];
				int ny = cur[1]+dy[k];
				
				if(nx<0 || ny<0 || ny>=N || nx>=N) {
					meter++;
				}else {
					
					if(map[nx][ny]==-1) meter++;
					
					if(map[nx][ny]==0) {
						que.offer(new int[] {nx,ny});
						map[nx][ny]=cnt;
						area++;
					}
				}
			}
		}
		
		
		return new int[] {area,meter};
	}

}
