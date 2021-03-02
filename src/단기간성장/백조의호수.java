package 단기간성장;
import java.util.*;
import java.io.*;

public class 백조의호수 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int[][] swan = new int[2][2];
		int index=0;
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			String str = bf.readLine();
			for(int j=0;j<C;j++) {
				char n = str.charAt(j);
				switch(n) {
				case '.':
					map[i][j]=0;
					que.offer(new int[] {i,j});
					break;
				case 'X':
					map[i][j]=-1;
					break;
				case 'L':
					swan[index][0]=i;
					swan[index][1]=j;
					index++;
					map[i][j]=0;
					que.offer(new int[] {i,j});
					break;
				}
			}
		}
		
		//map : 얼음 녹이는데까지 걸리는 시간 기록
		int day=0;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		while(!que.isEmpty()) {
			
			int SIZE = que.size();
			day++;
			while(SIZE-->0) {
				
				int[] cur = que.poll();
				
				for(int k=0;k<4;k++) {
					int nx = cur[0]+dx[k];
					int ny = cur[1]+dy[k];
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					if(map[nx][ny]==-1) {
						map[nx][ny]=day;
						que.offer(new int[] {nx,ny});
					}
				}
			}
		}
		
	//	for(int[] e:map)
		//	System.out.println(Arrays.toString(e));
		
		//swan[0] -> swan[1]로 도달하는 최소 day 구하기
		int[][] dp = new int[R][C];
		
		for(int[] e:dp)
			Arrays.fill(e,-1);
		
		dp[swan[0][0]][swan[0][1]]=0;
		que.offer(new int[] {swan[0][0],swan[0][1]});
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0]; int y=cur[1];
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
				
				//							5          3
				if(dp[nx][ny]==-1) {   //백조가 x y까지 오는데 걸린 시간 // nx,ny가 녹는데 걸리는 시간
					dp[nx][ny]=Math.max(dp[x][y], map[nx][ny]);
					que.offer(new int[] {nx,ny});
				}
				else if (dp[nx][ny]>Math.max(dp[x][y], map[nx][ny])) {
					dp[nx][ny]=Math.max(dp[x][y], map[nx][ny]);
					que.offer(new int[] {nx,ny});
				}
			}
			
		}
		
		
		System.out.println(dp[swan[1][0]][swan[1][1]]);
	}

}
