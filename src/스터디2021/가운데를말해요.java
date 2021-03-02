package ���͵�2021;
import java.util.*;
import java.io.*;

public class ��������ؿ� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		
		//N=1�̸� �׳� �װ� ���
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
		
		//N==2������ 1) num1 ���, 2)���� ������ ���
		bw.write(num1+"\n");
		bw.write(maxHeap.peek()+"\n");
		
		//N==3���� ~
		for(int i=3;i<=N;i++) {
			
			int num = Integer.parseInt(bf.readLine());
			
			//�ּ� ~ �߰� , �߰� ~ �ְ� 
			//max - minheap
			
			int mid2 = minHeap.peek();
			
			if(num<=mid2)
				maxHeap.offer(num);
			else
				minHeap.offer(num);
			
			//���� ũ�� ������
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
