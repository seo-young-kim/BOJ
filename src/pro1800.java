
import java.util.*;
import java.io.*;

public class pro1800 {
	static HashMap[] map;
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new HashMap[N];
		for(int i=0;i<N;i++)
			map[i]=new HashMap<Integer,Integer>();
		
		while(P-->0) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map[a].put(b,w);
			map[b].put(a,w);
		}
		
		boolean[] set = new boolean[N];
		set[0]=true;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//
	//	dfs(0,set,pq);
		if(min==987654321)
			min=-1;
		System.out.println(min);
	}
	
	static int min=987654321;
	public static void dfs(int s,boolean[] set,PriorityQueue<Integer> pq,int weight) {
		
		pq.offer(weight);
		
		if(s==N-1) {
			min = Math.min(min, pq.peek());
			return;
		}
		
		Iterator itr = map[s].keySet().iterator();
		
		while(itr.hasNext()) {
			
			int node = (Integer)itr.next();
			if(set[node]) continue;
			set[node]=true;
			dfs(s,set,pq,(Integer)map[s].get(node));
			set[node]=false;
		}
		
		
	}

}
