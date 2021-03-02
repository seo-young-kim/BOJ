import java.io.*;
import java.util.*;

public class 이모티콘 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		boolean[][] dp = new boolean[10000][10000];
		
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {1,0});
		dp[1][0]=true;
		int time=0;
		
outer:	while(true) {
	
			int SIZE = que.size();
			for(int i=0;i<SIZE;i++) {
			
				int[] cur = que.poll();
			
				int s = cur[0];
				int b = cur[1];
				
				if(s==N)
					break outer;
				
				//1. 화면에 있는 이모트콘을 복사에 클립보드에 저장한다.
				if(!dp[s][s]) {
					dp[s][s]=true;
					que.offer(new int[] {s,s});
				}
				//2. 클립보드에 있는 이모티콘을 화면에 붙여넣기 한다
				if(b>0 && !dp[s+b][b]) {
					dp[s+b][b]=true;
					que.offer(new int[] {s+b,b});
				}
				//3.화면에 있는 이모티콘 하나 삭제한다.
				if(s>1 && !dp[s-1][b]) {
					dp[s-1][b]=true;
					que.offer(new int[] {s-1,b});
				}
					
			}
			time++;
				
		}
		
		System.out.println(time);
		
	}
	
	
	
}
