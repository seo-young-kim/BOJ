package ���͵�2021_2;
import java.util.*;
import java.io.*;
public class ��������ũ {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//��� Map
		int[][] map = new int[N][N];
		for(int[] e:map)
			Arrays.fill(e,5);
		
		//�ܿ︶�� �߰��ϴ� ���
		int[][] A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				A[i][j]=Integer.parseInt(st.nextToken());
		}
		
		//���� ���� 
		PriorityQueue<int[]> pq[] = new PriorityQueue[2];
		int cur=0;
		int next=1;
		pq[cur]=new PriorityQueue<int[]>((o1,o2)->o1[2]-o2[2]);
		pq[next]=new PriorityQueue<int[]>((o1,o2)->o1[2]-o2[2]);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			pq[cur].offer(new int[] {x-1,y-1,year});
		}
		
		//���� ������ ����� ����صδ� �ӽ� �迭
		int[][] temp = new int[N][N];
		
		//���̰� 5�� ������ ����ϴ� list
		Queue<int[]> five = new LinkedList<>();
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int k=0;k<K;k++) {
			
			//pq���鼭 ���̸�ŭ ��� �԰� ���� ++�ؼ� pq next�� �ִ´�
			//temp[][]�� ���� ������ ��� �߰��Ѵ�.
			//���̰� 5�� ����ξֵ��� list�� ����� �д�.
			
			while(!pq[cur].isEmpty()) {
				
				int[] tree = pq[cur].poll();
				int r = tree[0];
				int c = tree[1];
				int y = tree[2];
				if(map[r][c]>=y) {
					//��� ���ƸԱ�
					map[r][c]-=y;
					//���� ���
					tree[2]++;
					pq[next].offer(tree);
					if(tree[2]%5==0)
						five.offer(tree);
				}else {
					temp[r][c]+=y/2;
				}
			}
			
			//������ �Դ�. map�� temp[]�� �����ش�. �׳� �ܿ�ŵ� ������. 
			for(int r=0;r<N;r++)
				for(int c=0;c<N;c++) {
					map[r][c]+=(temp[r][c]+A[r][c]);
					temp[r][c]=0;
				}
			
			//������ ����
			while(!five.isEmpty()) {
				int[] tree = five.poll();
				for(int d=0;d<8;d++) {
					int nx = tree[0]+dx[d];
					int ny = tree[1]+dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					pq[next].offer(new int[] {nx,ny,1});
				}
			}
			
			cur^=1;
			next^=1;
		}
		
		System.out.println(pq[cur].size());
		
	}

}
