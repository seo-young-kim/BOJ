package 단기간성장;
import java.util.*;
import java.io.*;

public class 해킹 {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		while(Tc-->0) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken())-1;
			
			HashMap[] map = new HashMap[N];
			
			for(int i=0;i<N;i++)
				map[i]=new HashMap<Integer,Integer>();
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());
				map[b].put(a,w);
			}
			
			int[] answer = dijstra(N,S,map);
			System.out.println(answer[0]+" "+answer[1]);
		}
		
	}
	
	public static int[] dijstra(int N,int s,HashMap[] map) {
		
		int cnt=1;
		int max=0;
		
		boolean[] S = new boolean[N];
		S[s]=true;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		
		Iterator itr = map[s].keySet().iterator();
		while(itr.hasNext()) {
			int next = (Integer)itr.next();
			int w = (Integer)map[s].get(next);
			pq.offer(new int[] {next,w});
		}
		
outer:	while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			
			while(S[cur[0]]) {
				if(pq.isEmpty())
					break outer;
				cur = pq.poll();
			}
			
			//cur이 다음 감염될거 정보
			int node = cur[0];
			int weight = cur[1];
			//몇초후에 걸리나요
			max = Math.max(max, cur[1]);
			S[node]=true;
			cnt++;
			
			//Relax
			itr = map[node].keySet().iterator();
			while(itr.hasNext()) {
				int next = (Integer)itr.next();
				if(S[next]) continue;
				int w = (Integer)map[node].get(next);
				pq.offer(new int[] {next,w+weight});
			}
			
			
		}
		
		
		return new int[] {cnt,max};
	}

}
