package 스터디2021;
import java.util.*;
import java.io.*;

public class 트럭 {

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
		
		//건너야할 트럭이 남아 있거나 트럭이 다리 위에 있으면 시간이 흘러야함
		while(next<N || !que.isEmpty()) {
			
			time++;
			
			//건너야할 트럭이 있지만 다리위에 아무것도 없음(맨처음만 해당)
			if(que.isEmpty()) {
				que.offer(new int[] {a[next],time+W});
				sum=a[next];
				next++;
			}else {//트럭이 있는 경우
				//맨 앞 트럭
				int[] front = que.peek();
				
				//맨 앞에 있는 트력이 나가는 시간?
				if(front[1]==time) { //빠질 시간이면
					que.poll(); //빼기
					sum-=front[0];	
				}
				
				//건널게 남아있고 트럭에 올릴 수 있으면 
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
