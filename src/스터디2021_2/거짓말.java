package ���͵�2021_2;
import java.util.*;
import java.io.*;

public class ������ {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visit_party = new boolean[M+1];
		boolean[] visit_person = new boolean[N+1];
		
		Queue<Integer> que = new LinkedList<>();
		
		st = new StringTokenizer(bf.readLine());
		//������ �ƴ� ���
		int K = Integer.parseInt(st.nextToken());
		for(int i=0;i<K;i++) {
			int truth=Integer.parseInt(st.nextToken());
			que.offer(truth);
			visit_person[truth]=true;
		}
		
		List[] party = new List[M+1];
		List[] person = new List[N+1];
		for(int i=1;i<=N;i++)
			person[i]=new LinkedList<>();
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(bf.readLine());
			//���� �ο� ��
			int p = Integer.parseInt(st.nextToken());
			party[i]=new LinkedList<>();
			while(p-->0) {
				int people = Integer.parseInt(st.nextToken());
				party[i].add(people);
				person[people].add(i);
			}
		}
		//������ �̾߱��ؾ��ϴ� ��Ƽ
		int cnt = 0;
				
		while(!que.isEmpty()) {
			//������ �ƴ� ���
			int cur_person = que.poll();
			
			Iterator<Integer> itr = person[cur_person].iterator();
			while(itr.hasNext()) {
				//cur�� �����ϴ� ��Ƽ���� ������ �̾߱��ؾ���
				int true_party=itr.next();
				if(visit_party[true_party])
					continue;
				visit_party[true_party]=true;
				cnt++;
				//�� ��Ƽ�� �����ϴ� ����� Ž��
				
				Iterator itr2 = party[true_party].iterator();
				while(itr2.hasNext()) {
					
					int true_people = (Integer)itr2.next();
					if(visit_person[true_people]) continue;
					visit_person[true_people]=true;
					que.offer(true_people);
				}
			}
			
		}
		
		System.out.println(M-cnt);
		
	}

}
