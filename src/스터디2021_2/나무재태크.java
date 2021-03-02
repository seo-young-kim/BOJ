package 스터디2021_2;
import java.util.*;
import java.io.*;
public class 나무재태크 {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//양분 Map
		int[][] map = new int[N][N];
		for(int[] e:map)
			Arrays.fill(e,5);
		
		//겨울마다 추가하는 양분
		int[][] A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				A[i][j]=Integer.parseInt(st.nextToken());
		}
		
		//나무 정보 
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
		
		//죽은 나무의 양분을 기록해두는 임시 배열
		int[][] temp = new int[N][N];
		
		//나이가 5인 나무를 기록하는 list
		Queue<int[]> five = new LinkedList<>();
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int k=0;k<K;k++) {
			
			//pq돌면서 나이만큼 양분 먹고 나이 ++해서 pq next에 넣는다
			//temp[][]에 죽은 나무의 양분 추가한다.
			//나이가 5의 배수인애들은 list에 기록해 둔다.
			
			while(!pq[cur].isEmpty()) {
				
				int[] tree = pq[cur].poll();
				int r = tree[0];
				int c = tree[1];
				int y = tree[2];
				if(map[r][c]>=y) {
					//양분 빨아먹기
					map[r][c]-=y;
					//나이 들기
					tree[2]++;
					pq[next].offer(tree);
					if(tree[2]%5==0)
						five.offer(tree);
				}else {
					temp[r][c]+=y/2;
				}
			}
			
			//여름이 왔다. map에 temp[]를 더해준다. 그냥 겨울거도 해주자. 
			for(int r=0;r<N;r++)
				for(int c=0;c<N;c++) {
					map[r][c]+=(temp[r][c]+A[r][c]);
					temp[r][c]=0;
				}
			
			//나무들 번식
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
