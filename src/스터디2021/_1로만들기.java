package 스터디2021;
import java.util.*;
import java.io.*;

public class _1로만들기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(N);
		
		int[] visit = new int[N+1];
		
		while(!que.isEmpty()) {
			
				
				int next = que.poll();
				if(next==1)
					break;
				
				if(next%3==0) {
					if(visit[next/3]==0) {
						visit[next/3]=visit[next]+1;
						que.offer(next/3);
					}
				}
				
				if(next%2==0) {
					if(visit[next/2]==0) {
						visit[next/2]=visit[next]+1;
						que.offer(next/2);
					}
				}
				

				if(visit[next-1]==0) {
					visit[next-1]=visit[next]+1;
					que.offer(next-1);
				}
		}
		
		System.out.print(visit[1]);
		
		
		
	}

}
