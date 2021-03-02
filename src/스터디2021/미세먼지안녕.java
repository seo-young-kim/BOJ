package 스터디2021;
import java.util.*;
import java.io.*;

public class 미세먼지안녕 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int[][] air = new int[2][2];
		int k=0;
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(bf.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==-1) {
					air[k][0]=r;
					air[k][1]=c;
					k++;
				}
			}
		}
		
		for(int t=0;t<T;t++) {
			blow(map);
			clean(map,air);
		}
		
		int sum=0;
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++)
				if(map[r][c]!=-1)
					sum+=map[r][c];
		
		System.out.println(sum);
	}
	
	public static void clean(int[][] map,int[][] air) {
		
		int R = map.length; int C = map[0].length;
		
		int[][] dx = {{-1,0,1,0},{1,0,-1,0}};
		int[][] dy = {{0,1,0,-1},{0,1,0,-1}};
		
		for(int a=0;a<2;a++) {
			
			int sx = air[a][0]; int sy = air[a][1];
			int k=0;
			
			int cx = sx+dx[a][k]; int cy = sy+dy[a][k];
			
			while(true) {
				
				int nx = cx +dx[a][k]; int ny = cy+dy[a][k];
				
				if(nx<0 || ny<0 || nx>=R || ny>=C) {
					k++;
					continue;
				} 
				
				if(nx==air[(a+1)%2][0] && ny==C-1) {
					k++;
					continue;
				}				
				if(map[nx][ny]==-1) {
					map[cx][cy]=0;
					break;
				}
				
				map[cx][cy]=map[nx][ny];
				cx = nx; cy=ny;
			}
			
			
		}
		
		
		
	}
	
	public static void print(int[][] map) {
		
		for(int[] e:map)
			System.out.println(Arrays.toString(e));
		System.out.println();
	}
	
	public static void blow(int[][] map) {
		
		int R = map.length; int C = map[0].length;
		
		int[][] add = new int[R][C];
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				
				if(map[r][c]==-1) continue;
				
				int origin=map[r][c];
				for(int k=0;k<4;k++) {
					int nx = r+dx[k];
					int ny = c+dy[k];
					if(nx<0 || nx>=R || ny>=C || ny<0 || map[nx][ny]==-1) continue;
					add[nx][ny]+=origin/5;
					map[r][c]-=origin/5;
				}
			}
		}
		
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				map[i][j]+=add[i][j];
		
	}

}
