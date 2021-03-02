package ���͵�2021;
import java.util.*;
import java.io.*;

public class �Ҽ���� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<Tc;i++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			if(p1==p2) {
				System.out.println(0);
				continue;
			}
			
			int num = findMinPath(p1,p2);
			if(num==-1)
				System.out.println("Impossible");
			else
				System.out.println(num);
			
		}
		
		
	}
	
	public static int findMinPath(int src,int target) {
		
		Queue<int[]> que = new LinkedList<>();
		boolean[] visit = new boolean[10000];
		
		int cnt=0;
		visit[src]=true;
		
		int[] arr = new int[4];
		for(int i=0;i<4;i++) {
			arr[i]=src%10;
			src = src/10;
		}
		
		que.offer(arr);
		
		while(!que.isEmpty()) {
			
			//src���� cnt�� ���ļ� �� �� �ִ� ���ڵ��� ����
			int size = que.size();
			
			while(size-->0) {
				int[] cur = que.poll();
				// i��° ���ڸ� �ٲ㼭 ������ �ȳ��԰� �Ҽ��ΰ� ã�ƾ���
				for(int i=0;i<4;i++) {
					
					//next�� ����
					int[] next = new int[4];
					for(int m=0;m<4;m++)
						next[m]=cur[m];
					
					for(int n=0;n<10;n++) {
						if(cur[i]==n) continue;
						if(i==3 && n==0) continue;
						
						//���ο� ���� ������ ��
						next[i]=n;
						//���ο� ���� ���
						int new_ = next[0]+next[1]*10 + next[2]*100 + next[3]*1000;
						if(visit[new_] || !isPrime(new_)) continue;
						
						if(new_==target) return cnt;
						que.offer(next);
						visit[new_]=true;
					}
					
				}
				
			}
			
			cnt++;
		}
		
		return -1;
	}
	
	public static boolean isPrime(int num) {
		
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) return false;
		}
		
		
		return true;
	}

}
