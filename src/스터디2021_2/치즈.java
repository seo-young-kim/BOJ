package ���͵�2021_2;
import java.util.*;
import java.io.*;

//������ �Ǽ��� �κ� ���� �α�**********!!!!!!!!!!!!!!!!!!!111

public class ġ�� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//ġ�� ��
		int[][] map = new int[R][C];
		//ġ���� ����
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
			//map���� ���� �κ��� true�� üũ�ؼ� return
			boolean[][] air = check(map);
			//map���� air�����ؼ� map���� ���̰� � �쿴���� return
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
