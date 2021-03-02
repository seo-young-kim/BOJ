package ���͵�2021;
import java.io.*;
import java.util.*;

public class ȸ�ǽǹ��� {

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
		
		//���� �ð��� �������� ���� (���� ��� ������ �ð��� ū�� ��)
		Arrays.sort(meet,new Comparator<int[]>() {public int compare(int[] o1,int[] o2) {
															if(o1[0]!=o2[0]) return o1[0]-o2[0];
															else return o2[1]-o1[1]; }});
		
		int[] dp = new int[end+2];
		Arrays.fill(dp, -1);
		dp[end+1]=0;
		
	    //���� ���߿� �����ϴ� ���ú��� �����
		int cur = N-1;
		
		for(int t=end;t>=0;t--) {
			
			while(cur>0 && meet[cur][0]>t)
				cur--;
			
			
			//���� ������ �� �ִ� ������ ����
			if(meet[cur][0]==t) {
				
				//�������ڸ��� ������ ���� ������ �� �� ����
				if(meet[cur][0]==meet[cur][1]) {
					dp[t]=dp[t+1]+1;
				}else			// ���ϰų�     �ϰų�
					dp[t]=Math.max(dp[t+1], 1+dp[meet[cur][1]]);
				
				if(cur>0)
					cur--;
				
			}else {//����
				
				dp[t]=dp[t+1];
			
			}
			
		}
		
		System.out.println(dp[0]);
		
	}

}
