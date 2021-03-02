package ���͵�2021;
import java.util.*;
import java.io.*;

public class �α��̵� {

	static int N,L,R;
	static int map[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		while(move())
			count++;
		
		System.out.println(count);
	}
	
	public static boolean move() {
		
		int[][] visit = new int[N][N];
		int cnt=1;
		boolean flag = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(visit[i][j]==0) {
					//�湮 ���Ѱ��� ������ �ű���� �����ΰ� �� cnt�� ä��
					//bfs�� true�� �α��̵� �Ѱ�
					if(bfs(i,j,cnt,visit))
						flag=true;
					cnt++;
				}
		}
		
		return flag;
	}
	
	public static boolean bfs(int sx,int sy,int color,int[][] visit) {
		
		visit[sx][sy]=color;
		int sum = map[sx][sy];
		int cnt = 1;
		
		//1. bfs
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sx,sy});
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
		
			int[] cur = que.poll();
			int cx = cur[0]; int cy= cur[1];
			
			for(int k=0;k<4;k++) {
				int nx = cx+dx[k];
				int ny = cy+dy[k];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(visit[nx][ny]!=0) continue;
				int d = Math.abs(map[cx][cy]-map[nx][ny]);
				if(d>=L && d<=R) {
					visit[nx][ny]=color;
					sum+=map[nx][ny];
					cnt++;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		
		if(cnt==1)
			return false;
		//2. AVE ���ؼ� ä���
		int ave = sum/cnt;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(visit[i][j]==color)
					map[i][j]=ave;
		
		return true;
		
	}
	

}
