package 스터디2021;
import java.io.*;
import java.util.*;

public class 회의실배정 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] meet = new int[N][2];
		
		int end=0;
		
		for(int i=0;i<N;i++) {
		
			StringTokenizer st = new StringTokenizer(bf.readLine());
			meet[i][0]=Integer.parseInt(st.nextToken());
			meet[i][1]=Integer.parseInt(st.nextToken());
			end = Math.max(end, meet[i][1]);
		
		}
		
		//시작 시간을 기준으로 정렬 (같은 경우 끝나는 시간이 큰게 앞)
		Arrays.sort(meet,new Comparator<int[]>() {public int compare(int[] o1,int[] o2) {
															if(o1[0]!=o2[0]) return o1[0]-o2[0];
															else return o2[1]-o1[1]; }});
		
		int[] dp = new int[end+2];
		Arrays.fill(dp, -1);
		dp[end+1]=0;
		
	    //가장 나중에 시작하는 미팅부터 고려함
		int cur = N-1;
		
		for(int t=end;t>=0;t--) {
			
			while(cur>0 && meet[cur][0]>t)
				cur--;
			
			
			//지금 시작할 수 있는 미팅이 있음
			if(meet[cur][0]==t) {
				
				//시작하자마자 끝나는 미팅 무조건 할 수 있음
				if(meet[cur][0]==meet[cur][1]) {
					dp[t]=dp[t+1]+1;
				}else			// 안하거나     하거나
					dp[t]=Math.max(dp[t+1], 1+dp[meet[cur][1]]);
				
				if(cur>0)
					cur--;
				
			}else {//없음
				
				dp[t]=dp[t+1];
			
			}
			
		}
		
		System.out.println(dp[0]);
		
	}

}
