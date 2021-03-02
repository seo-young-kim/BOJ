package ���͵�2021_2;
import java.util.*;
import java.io.*;
public class ���� {

	static int N,M;
	static int[][] map;
	static int[][] mark;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mark = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		//�� ��ȣ mark & ���� ����
		int numOfRoom=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(mark[i][j]==0) {
					numOfRoom++;
					bfs(i,j,numOfRoom);
				}
		
		//�� ���� ���� ���ϱ�
		int[] rooms = new int[numOfRoom+1];
		int maxArea = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				rooms[mark[i][j]]++;
		
		//���� ū ���� ũ��
		for(int i=1;i<=numOfRoom;i++)
			maxArea = Math.max(maxArea,rooms[i]);
		
		//�ΰ� �� ������ �� �ִ� ũ��?
		int mergeMax=0;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				if(i<N-1 && mark[i][j]!=mark[i+1][j])
						mergeMax = Math.max(mergeMax,rooms[mark[i][j]]+rooms[mark[i+1][j]]);
				
				if(j<M-1 && mark[i][j]!=mark[i][j+1])
						mergeMax = Math.max(mergeMax,rooms[mark[i][j]]+rooms[mark[i][j+1]]);
			}
		
		System.out.print(numOfRoom+"\n"+maxArea+"\n"+mergeMax);;
		
	}
					// �� �� �� �� 
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	
	public static void bfs(int i,int j,int numOfRoom) {
		
		Queue<int[]> que = new LinkedList<>();
		mark[i][j]=numOfRoom;
		que.offer(new int[] {i,j});
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int k=0;k<4;k++) {
				
				int wall = (1<<k);
				//�������� ���� ����
				if((map[cx][cy]&wall)!=0) continue;
				int nx = cx+dx[k];
				int ny = cy+dy[k];
				//����ų� �̹� �湮��
				if(nx<0 ||ny<0 || nx>=N || ny>=M || mark[nx][ny]!=0) continue;
				//������ �� �� ����
				mark[nx][ny]=numOfRoom;
				que.offer(new int[] {nx,ny});
				
			}
		}
		
	}

}
