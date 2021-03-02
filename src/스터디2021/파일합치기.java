package 스터디2021;
import java.util.*;
import java.io.*;

public class 파일합치기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=Tc;t++) {
			int K = Integer.parseInt(bf.readLine());
			StringTokenizer st =new StringTokenizer(bf.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>();
			int[] arr = new int[K];
			for(int i=0;i<K;i++)
				que.offer(Integer.parseInt(st.nextToken()));
			
			
			int sum=0;
			while(que.size()>1) {
				
			/*	Iterator itr = que.iterator();
				while(itr.hasNext())
					System.out.print(itr.next()+" ");
				System.out.println();
				*/
				int num1 = que.poll();
				int num2= que.poll();
				sum+=(num1+num2);
				que.offer(num1+num2);
				System.out.println(String.valueOf(num1)+" + "+String.valueOf(num2)+" ="+(num1+num2) + "    sum="+sum);
			}
			System.out.println(sum);
		}
		
	}

}
