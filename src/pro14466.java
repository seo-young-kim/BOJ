
import java.util.*;
import java.io.*;

public class pro14466 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		//소
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] list = new int[N][N];

		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(bf.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			
			for(int k=0;k<4;k++)
				if(r1+dx[k]==r2 && c1+dy[k]==c2) {
					list[r1][c1]|=(1<<k);
					break;
				}
			
			for(int k=0;k<4;k++)
				if(r2+dx[k]==r1 && c2+dy[k]==c1) {
					list[r2][c2]|=(1<<k);
					break;
				}
		}
		
		int[][] map = new int[N][N];
		int[][] cow = new int[K+1][2];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1]=i+1;
			cow[i+1][0]=r-1;
			cow[i+1][1]=c-1;
		}
		
		int sum=0;
		//i가 만날 수 있는 소 세기
		for(int i=1;i<=K;i++) {
			
			boolean[][] visit = new boolean[N][N];
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {cow[i][0],cow[i][1]});
			visit[cow[i][0]][cow[i][1]]=true;
			int cnt=0; //만날 수 있는 소의 쌍
			while(!que.isEmpty()) {
				
				int[] cur = que.poll();
				int x = cur[0]; int y = cur[1];
				
				for(int k=0;k<4;k++) {
					
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					
					if((list[x][y]&(1<<k))!=0)
						continue;//길건너야함
					
					if(visit[nx][ny]) continue;
					
					if(map[nx][ny]>i) cnt++;
					que.offer(new int[] {nx,ny});
					visit[nx][ny]=true;
				}
			}
			// K-i 만큼 고려됨 
			sum+=(K-i)-cnt;
			
		}
		
		System.out.println(sum);
		
	}

}
