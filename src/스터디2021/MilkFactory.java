package 스터디2021;
import java.util.*;
import java.io.*;

public class MilkFactory {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		//adjacent list
		List[] list = new List[N+1];
		for(int i=1;i<=N;i++)
			list[i]=new LinkedList<>();
		
		//input counter
		int[] in = new int[N+1];
		
		for(int i=1;i<N;i++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			in[b]++;
			list[a].add(b);
		}
		
		// i노드를 거쳐가는 노드의 개수
		int[] dp = new int[N+1];
		
		Queue<Integer> que = new LinkedList<>();
		
		//in노드 개수가 0인 노드를 큐에 넣음
		for(int i=1;i<=N;i++)
			if(in[i]==0)
				que.offer(i);
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			Iterator itr = list[cur].iterator();
			
			while(itr.hasNext()) {
				
				int next = (Integer)itr.next();
				dp[next]+=dp[cur]+1;
				in[next]--;
				
				if(in[next]==0)
					que.offer(next);
			}
		}
		
		int min=-1;
		for(int i=N;i>0;i--)
			if(dp[i]==N-1)
				min = i;
		
		System.out.println(min);
	}

}
