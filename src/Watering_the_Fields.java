import java.util.*;
import java.io.*;

public class Watering_the_Fields {

	static int N,C;
	static int[][] adj;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] loc = new int[N][2];
		
		adj = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			loc[i][0]=Integer.parseInt(st.nextToken());
			loc[i][1]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++) {
				int x = loc[i][0]-loc[j][0];
				int y = loc[i][1]-loc[j][1];
				int dis = Math.abs(x*x+y*y);
				if(dis>=C) {
					adj[i][j]=dis;
					adj[j][i]=dis;
				}
			}
		
		System.out.println( prim());
	
		
	}
	
	public static int prim() {
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		boolean[] S = new boolean[N];
		
		S[0] = true;
		
		for(int i=1;i<N;i++)
			if(adj[0][i]>0)
				pq.offer(new int[] {i,adj[0][i]});	
		
		int cost=0;
		
		for(int i=1;i<N;i++) {
			
			//다음 포함할 노드 찾기 =
			if(pq.size()==0) return -1;
			int[] cur = pq.poll();
			
			while(S[cur[0]]) {
				if(pq.size()==0) return -1;
				cur = pq.poll();
			}
			
			S[cur[0]]=true;
			cost+=cur[1];
			
			for(int k=1;k<N;k++) {
				if(S[k]) continue;
				if(adj[cur[0]][k]>0)
					pq.offer(new int[] {k,adj[cur[0]][k]});	
			}
		}
		
		return cost;
		
	}

}