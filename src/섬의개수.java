import java.io.*;
import java.util.*;

public class ¼¶ÀÇ°³¼ö {

	static int w,h;
	
	static int[][] land;
	
	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		
			StringTokenizer st = new StringTokenizer(bf.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0)
				break;
			
			land = new int[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<w;j++)
					land[i][j]=Integer.parseInt(st.nextToken());
			}
			
			int count=0;
			
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++) {
					if(land[i][j]==1) {
						count++;
						bfs(i,j);
					}
				}
			
			System.out.println(count);
		
		}
	}
	
	public static void bfs(int i,int j) {
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i,j});
		
		land[i][j]=2;
		
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		while(!que.isEmpty()) {
			
			int[] now = que.poll();
			int x = now[0];
			int y = now[1];
			
			for(int k=0;k<8;k++) {
				
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx>=h || ny<0 || ny>=w)
					continue;
				if(land[nx][ny]==1) {
					land[nx][ny]=2;
					que.offer(new int[] {nx,ny});
				}
				
			}
			
		}
		
		
	}

}
