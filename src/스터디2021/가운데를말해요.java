package 스터디2021;
import java.util.*;
import java.io.*;

public class 가운데를말해요 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		
		//N=1이면 그냥 그거 출력
		if(N==1) {
			System.out.println(bf.readLine());
			return;
		}
		
		//N>=2
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2)->o1-o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2)->o2-o1);
		
		int num1 = Integer.parseInt(bf.readLine());
		int num2 = Integer.parseInt(bf.readLine());
		
		maxHeap.offer(Math.min(num1,num2));
		minHeap.offer(Math.max(num1,num2));
		
		//N==2까지는 1) num1 출력, 2)둘중 작은거 출력
		bw.write(num1+"\n");
		bw.write(maxHeap.peek()+"\n");
		
		//N==3부터 ~
		for(int i=3;i<=N;i++) {
			
			int num = Integer.parseInt(bf.readLine());
			
			//최소 ~ 중값 , 중값 ~ 최고값 
			//max - minheap
			
			int mid2 = minHeap.peek();
			
			if(num<=mid2)
				maxHeap.offer(num);
			else
				minHeap.offer(num);
			
			//양쪽 크기 맞춰줌
			if(minHeap.size()+1<maxHeap.size())
				minHeap.offer(maxHeap.poll());
			
			if(maxHeap.size()<minHeap.size())
				maxHeap.offer(minHeap.poll());
			
			bw.write(maxHeap.peek()+"\n");
			if(i%100==0)
				bw.flush();
		}
		bw.close();
	}
}
