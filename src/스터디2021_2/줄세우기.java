package ���͵�2021_2;
import java.util.*;
import java.io.*;
public class �ټ���� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//���� �迭 
		int[] answer = new int[N];
		int index = 0; //answer tracking ����
		
		//������ ���� ���;��ϴ� �л� ��
		int[] parent = new int[N];
		
		//Directed Graph
		List[] list = new List[N];
		for(int i=0;i<N;i++)
			list[i] = new LinkedList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a-1].add(b-1);
			parent[b-1]++;
		}
		
		//�� �������� True
		boolean[] visit = new boolean[N];
		
		//0�ξֵ� ť�� �ֱ�
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<N;i++)
			if(parent[i]==0) {
				visit[i]=true;
				answer[index++]=i;
				que.offer(i);
			}
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			Iterator itr = list[cur].iterator();
			while(itr.hasNext()) {
				
				int next = (Integer)itr.next();
				parent[next]--;
				if(parent[next] == 0) {
					que.offer(next);
					visit[next]=true;
					answer[index++]=next;
				}
			}
		}
		
		if(index<N) {
			for(int i=0;i<N;i++)
				if(!visit[i])
					answer[index++]=i;
		}
		
		for(int i=0;i<N;i++)
			System.out.print((answer[i]+1)+" ");
	}

}
