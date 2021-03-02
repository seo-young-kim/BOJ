package 단기간성장;
import java.util.*;
import java.io.*;

public class 가운데를말해요 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		
		int num = Integer.parseInt(bf.readLine());
		
		if(N==1) {
			System.out.println(num);
			return;
		}
		int num2 = Integer.parseInt(bf.readLine());
		if(N==2) {
			System.out.println(Math.min(num, num2));
			return;
		}
		
		left.offer(Math.min(num, num2));
		right.offer(Math.max(num, num2));
		System.out.println(left.peek());
		System.out.println(left.peek());
		
		for(int i=3;i<=N;i++) {
			
			num = Integer.parseInt(bf.readLine());
			
			if(i%2>0) {
				
				int mid1 = left.peek();
				int mid2 = right.peek();
				
				if(num<=mid1) {
					left.offer(num);
					System.out.println(left.peek());
				}else {
					right.offer(num);
					System.out.println(right.peek());
				}
				
			}else {//한쪽이 더 큼
				
				int mid1 = left.peek();
				
				if(num<=mid1) {
					left.offer(num);
				}else {
					right.offer(num);
				}
				
				int ls = left.size();
				int rs = right.size();
				
				
				if(ls<rs)
					left.offer(right.poll());
				if(rs<ls)
					right.offer(left.poll());
				
				System.out.println(left.peek());
					
			}
			
			
		}
	}
	
}