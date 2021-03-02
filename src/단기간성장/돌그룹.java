package 단기간성장;
import java.util.*;
import java.io.*;

public class 돌그룹 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] num = new int[3];
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());
		int sum = num[0]+num[1]+num[2];
		
		if(sum!= (sum/3)*3) {
			System.out.println(0);
			return;
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(num);
		boolean[][] chk = new boolean[2001][2001];
		chk[num[0]][num[1]]=true;
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			
			if(cur[0]==cur[1] && cur[1]==cur[2]) {
				System.out.print(1);
				return;
			}
			
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					if(cur[j]-cur[i]>0) {
						int[] case1 = {2*cur[i],cur[j]-cur[i],sum-(cur[i]+cur[j])};
						if(!chk[case1[0]][case1[1]]) {
							chk[case1[0]][case1[1]]=true;
							que.offer(case1);
						}
					}
			
		}
		
		System.out.println(0);
		
	}
}