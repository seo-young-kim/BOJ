package 단기간성장;
import java.util.*;
import java.io.*;

public class 레이저통신 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		int sx=-1;int sy=-1;
		int ex=-1; int ey=-1;
		
		for(int i=0;i<R;i++) {
			String str = bf.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='C') {
					if(sx==-1) {
						sx=i;sy=j;}
					else {
						ex=i; ey=j;}
				}
			}
		}
		
		boolean[][] visited = new boolean[R][C];
		
		visited[sx][sy]=true;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sx,sy});
		
		int cnt=-1;
		
		while(!que.isEmpty()) {
			
			int size=que.size();
			cnt++;
			while(size-->0) {
				
				int[] m = que.poll();
				int x = m[0]; int y=m[1];
				
				for(int k=0;k<4;k++) {
					
					int nx = x+dx[k];
					int ny = y+dy[k];
					
					while(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny]!='*') {
						if(nx==ex && ny==ey) {
							System.out.println(cnt);
							return; 
							}
						if(!visited[nx][ny]) {
							que.offer(new int[] {nx,ny});
							visited[nx][ny]=true;
						}
						nx+=dx[k];
						ny+=dy[k];
					}
				}
			}
		}
	}
}