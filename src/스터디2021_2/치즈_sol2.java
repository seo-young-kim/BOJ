package ���͵�2021_2;
import java.util.*;
import java.io.*;

public class ġ��_sol2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
		
		Queue<int[]>[] que = new LinkedList[2];
		
		que[0]=new LinkedList<>();
		que[1]=new LinkedList<>();
		
		int cur=0; int next=1;
		
		que[cur].offer(new int[] {0,0});
		
		int time=0;
		
		int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
		
		boolean[][] visit = new boolean[R][C];
		visit[0][0]=true;
		
		//ġ� �� ���������� �ݺ�
		while(total>0) {
			
			time++;
			
			while(!que[cur].isEmpty()) {
				int[] air = que[cur].poll();
				int cx = air[0];
				int cy = air[1];
				
				for(int k=0;k<4;k++) {
					int nx = cx+dx[k];
					int ny = cy+dy[k];
					if(nx<0 || ny<0 || nx>=R || ny>=C || visit[nx][ny]) continue;
					 
					visit[nx][ny]=true;
					
					//�����¾ֵ��� 0�̸� �ٱ�����, 1�̸� ġ��
					if(map[nx][ny]==0) {
						que[cur].offer(new int[] {nx,ny});
					}else {
						que[next].offer(new int[] {nx,ny});
						map[nx][ny]=0;
						total--;
					}
				}
			}
			//cur nextü���� 
			
			cur^=1;
			next^=1;
			
		}
		
		System.out.println(time);
		System.out.println(que[cur].size());
		
		
	}

}
