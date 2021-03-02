package 스터디2021;
import java.util.*;
import java.io.*;

public class 최소힙 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		while(N-->0) {
			
			int x = Integer.parseInt(bf.readLine());
			
			if(x>0) {
				pq.offer(x);
			}else {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
		}
		
		
	}

}
