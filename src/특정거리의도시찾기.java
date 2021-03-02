import java.io.*;
import java.util.*;

public class 특정거리의도시찾기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List[] list = new List[N+1];
		for(int i=1;i<=N;i++)
			list[i]=new LinkedList<>();
			
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(X);
		
		boolean[] check = new boolean[N+1];
		check[X]=true;
		
		for(int dist=0;dist<K;dist++) {
			int size = que.size();
			
			while(size-->0) {
				int cur = que.poll();
				Iterator itr = list[cur].iterator();
				while(itr.hasNext()) {
					
					int next = (Integer)itr.next();
					if(!check[next]) {
						check[next]=true;
						que.offer(next);
					}
				}
			}
		}
		if(que.size()==0)
			System.out.println(-1);
		else {
			int[] answer = new int[que.size()];
			int k=0;
			while(!que.isEmpty()) {
				answer[k++]=que.poll();
			}
			Arrays.sort(answer);
			for(int i=0;i<k;i++)
				System.out.println(answer[i]);
		}
	}

}
