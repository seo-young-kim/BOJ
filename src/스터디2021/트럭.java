package ���͵�2021;
import java.util.*;
import java.io.*;

public class Ʈ�� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int[] a = new int[N];
		for(int i=0;i<N;i++)
			a[i]=Integer.parseInt(st.nextToken());
		
		Queue<int[]> que = new LinkedList<>();
		
		int time=0;
		int next=0;
		int sum =0;
		
		//�ǳʾ��� Ʈ���� ���� �ְų� Ʈ���� �ٸ� ���� ������ �ð��� �귯����
		while(next<N || !que.isEmpty()) {
			
			time++;
			
			//�ǳʾ��� Ʈ���� ������ �ٸ����� �ƹ��͵� ����(��ó���� �ش�)
			if(que.isEmpty()) {
				que.offer(new int[] {a[next],time+W});
				sum=a[next];
				next++;
			}else {//Ʈ���� �ִ� ���
				//�� �� Ʈ��
				int[] front = que.peek();
				
				//�� �տ� �ִ� Ʈ���� ������ �ð�?
				if(front[1]==time) { //���� �ð��̸�
					que.poll(); //����
					sum-=front[0];	
				}
				
				//�ǳΰ� �����ְ� Ʈ���� �ø� �� ������ 
				if(next<N && a[next]+sum<=L) {
					que.offer(new int[] {a[next],time+W});
					sum+=a[next];
					next++;
				}
			}
		}
		
		System.out.println(time);
		
	}

}
