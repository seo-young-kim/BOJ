import java.util.*;
import java.io.*;

public class MoonTube {

	static int N;
	static HashMap[] map;
	static int[][] USA;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		map = new HashMap[N];
		for(int i=0;i<N;i++)
			map[i]=new HashMap<Integer,Integer>();
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map[x].put(y,w);
			map[y].put(x,w);
		}
		
		USA = new int[N][N];
		
		//USA�� ���
		compute();
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int count=0;
			for(int j=0;j<N;j++)
				if(USA[v][j]>=k)
					count++;
			System.out.println(count);
		}
	}
	
	public static void compute() {
		
		for(int i=0;i<N;i++) {
			
			//i���� ���絵 ���
			//���� �ٷ� ����Ǿֵ� �ִ´�.
			Queue<int[]> que = new LinkedList<>();
			
			Iterator itr = map[i].keySet().iterator();
			while(itr.hasNext()) {
				int next = (Integer)itr.next();
				int w = (Integer)map[i].get(next);
				que.offer(new int[] {next,w});
				USA[i][next]=w;
			}
			
			while(!que.isEmpty()) {
				
				int[] cur = que.poll();
				int node = cur[0];
				int min = cur[1];
				
				//node�� ����Ǿ� �ִ� �ֵ� �� ����
				itr = map[node].keySet().iterator();
				
				while(itr.hasNext()) {
					//node �� �ٷ� ����Ǿ� �ִ� �ֵ�
					int next = (Integer)itr.next();
					int w = (Integer)map[node].get(next);
					
					if(USA[i][next]>0 || next==i) continue;
					
					w = Math.min(min, w);
					que.offer(new int[] {next,w});
					USA[i][next]=w;
				}
				
			}
		}
		
			
	}

}
