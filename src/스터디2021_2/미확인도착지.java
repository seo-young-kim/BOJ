package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 미확인도착지 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Tc = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=Tc;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int g = Integer.parseInt(st.nextToken())-1;
			int h = Integer.parseInt(st.nextToken())-1;
			
			//adj 리스트
			HashMap[] adj = new HashMap[n];
			
			for(int i=0;i<n;i++)
				adj[i] = new HashMap<Integer,Integer>();
			
			for(int e=0;e<m;e++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());
				adj[a].put(b, w);
				adj[b].put(a, w);
			}
			
			boolean[] flag = dijk(adj,s,g,h);
			boolean[] target = new boolean[n];
			
			for(int T=0;T<t;T++) {
				int nt = Integer.parseInt(bf.readLine());
				target[nt-1]=true;
			}
			//가능한거 해서 
			
			for(int i=0;i<n;i++)
				if(target[i]&&flag[i])
					bw.write((i+1)+" ");
			//출력
			bw.flush();
		}
		
		bw.close();
	}
	static final int INF = 987654321;
	public static boolean[] dijk(HashMap[] adj, int s,int g,int h) {
		
		int N = adj.length;
		
		//다익스트라 자료구조
		boolean[] S = new boolean[N];
		int[] dij = new int[N];
		Arrays.fill(dij, INF);
		dij[s]=0;
		
		//i번째 가는 최단 경로에 g-h가 있는가?
		boolean[] flag = new boolean[N]; 

		// (i,w) s->i까지 가는 최단 경로 w
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pq.offer(new int[] {s,0});
		
		while(!pq.isEmpty()) {
			
			//가장 작은 애는 이제 최소임
			int[] cur = pq.poll();
			if(S[cur[0]]) continue;
			
			int cx = cur[0];
			S[cx]=true;
			
			Iterator itr = adj[cx].keySet().iterator();
			
			while(itr.hasNext()) {
				
				int next = (Integer)itr.next();
				if(S[next]) continue;
				int weight = (Integer)adj[cx].get(next);
				
				//realx해서 같은 경우, 굳이 또 que에 넣어줄 필요가 없음
				//또한 flag[next]=True라면 지나간 거니까 update안해줌
				//flag[next]=False라면 true가 될수 있는지 본다.
				if(dij[next]==dij[cx]+weight && !flag[next]) {
					flag[next] = flag[cx];
					if(isRoad(next,cx,g,h))
						flag[next]=true;
				}
				
				//relax
				if(dij[next]>dij[cx]+weight) {
					//cx가 true면 true, false면 false
					flag[next] = flag[cx];
					//또는 그 길이면 true
					if(isRoad(next,cx,g,h))
						flag[next]=true;
					
					dij[next]=dij[cx]+weight;
					pq.offer(new int[] {next,dij[next]});
				}
			}
			
		}
		
		return flag;
	}
	
	public static boolean isRoad(int a,int b,int g,int h) {
		if(a==g && b==h) return true;
		if(a==h && b==g) return true;
		return false;
	}

}
