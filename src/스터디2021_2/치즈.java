package 스터디2021_2;
import java.util.*;
import java.io.*;

//앞으로 실수한 부분 적어 두기**********!!!!!!!!!!!!!!!!!!!111

public class 치즈 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//치즈 판
		int[][] map = new int[R][C];
		//치즈의 개수
		int total=0;
		
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(bf.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==1)
					total++;
			}
		}
		
		if(total==0) {
			System.out.println(0+"\n"+0);
			return;
		}
		
		int time=0;
		
		
		
		while(true) {
			
			time++;
			//map에서 공기 부분을 true로 체크해서 return
			boolean[][] air = check(map);
			//map에서 air참고해서 map에서 녹이고 몇개 녹였는지 return
			int melted = melt(map,air);
			if(total==melted)
				break;
			total-=melted;
		}
		
		System.out.println(time);
		System.out.println(total);
		
	}
	
	public static boolean[][] check(int[][] map){
		int R = map.length;
		int C = map[0].length;
		boolean[][] air = new boolean[R][C];
		
		Queue<int[]> que = new LinkedList<>();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		que.offer(new int[] {0,0});
		air[0][0]=true;
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int cx = cur[0]; int cy = cur[1];
			
			for(int k=0;k<4;k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if(nx<0 || ny< 0 || nx>=R || ny>=C) continue;
				if(map[nx][ny]==0 && !air[nx][ny]) {
					air[nx][ny]=true;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		return air;
	}
	
	public static void print(Object[][] arr) {
		
		for(Object[] e:arr)
			System.out.println(Arrays.toString(e));
		System.out.println();

	}
	public static int melt(int[][] map, boolean[][] air) {
		
		int cnt=0;
		int R = map.length;
		int C = map[0].length;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++) {
				
				if(map[r][c]==0) continue;
				
				for(int k=0;k<4;k++) {
					int nx = r+dx[k];
					int ny = c+dy[k];
					if(air[nx][ny]) {
						map[r][c]=0;
						cnt++;
						break;
					}	
				}
			}
		return cnt;
	}
}
