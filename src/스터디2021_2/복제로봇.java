package 스터디2021_2;
import java.io.*;
import java.util.*;

public class 복제로봇 {
	
	static int[][] map;
	static int[][] dist;
	static int N,M;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//각 node의 위치를 저장
		int[][] node = new int[M+2][2];
		int index=1;
		
		//좌표
		map = new int[N][N];
	
		char next;
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<N;j++) {
				 next=str.charAt(j);
				if(next=='S' || next=='K') {
					//각 node의 위치를 저장
					node[index][0]=i;
					node[index][1]=j;
					map[i][j]=index;
					index++;
				}else {
					map[i][j]=(next=='1')?-1:0;
				}
			}
		}
		
		//1. adjcent 행렬 dist 구하기
		dist = new int[M+2][M+2];
		if(adjcent(node)==-1) {
			System.out.println(-1);
			return;
		}
		
		//2. MST
		System.out.println(prim());
		//3. 출력
		
	}
	
	
	public static int prim() {
		
		int answer=0;
		//dist보고... MST 뭔지 찾아보 ㅏ어라ㅣㄴ어라ㅣㅇ너리ㅏ
		
		//node=1 to M+1까지임
		boolean[] S = new boolean[M+2];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		
		pq.offer(new int[] {1,0});
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			if(S[cur[0]]) continue;
			
			S[cur[0]]=true;
			answer+=cur[1];
			
			for(int i=1;i<=M+1;i++)
				if(!S[i])
					pq.offer(new int[] {i,dist[cur[0]][i]});
			
		}
		
		
		return answer;
	}
	
	public static int adjcent(int[][] node) {
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		//node i부터 i이상의 노드까지의 거리구해서 dist[i][j]에 입력
		for(int i=1;i<=M+1;i++) {
			
			//node[i]부터 시작해 다른 node로 가는 거리 구하기
			//BFS
			int[][] visit = new int[N][N];
			for(int[] e: visit)
				Arrays.fill(e,-1);
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {node[i][0],node[i][1]});
			visit[node[i][0]][node[i][1]]=0;
			while(!que.isEmpty()) {
				
				int[] cur = que.poll();
				int cx = cur[0];
				int cy = cur[1];
				
				for(int k=0;k<4;k++) {
					int nx = cx+dx[k];
					int ny = cy+dy[k];
					if(nx<0 || ny<0 || nx>=N ||ny>=N) continue;
					if(map[nx][ny]==-1) continue;
					if(visit[nx][ny]!=-1) continue;
					visit[nx][ny]=visit[cx][cy]+1;
					que.offer(new int[] {nx,ny});
				}
			}
			
			//dist채우기
			for(int j=1;j<=M+1;j++) {
				int x = node[j][0];
				int y = node[j][1];
				
				dist[i][j]=visit[x][y];
				if(dist[i][j]==-1) return -1;
			}
			
		}
		return 0;
	}

}
