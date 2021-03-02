package ���͵�2021;
import java.util.*;
import java.io.*;

public class ���̷��� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//����� ���� N, ������ ���� M
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		//adj ����Ʈ
		List[] list = new List[N+1];
		
		for(int i=1;i<=N;i++)
			list[i]=new LinkedList<>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		//�湮 ���� �迭 visit
		boolean[] visit = new boolean[N+1];
		
		//bfs
		Queue<Integer> que = new LinkedList<>();
		int cnt = 0;
		que.offer(1);
		visit[1]=true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			Iterator itr = list[cur].iterator();
			while(itr.hasNext()) {
				int next = (Integer)itr.next();
				if(!visit[next]) {
					visit[next]=true;
					que.offer(next);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		
	}

}
