import java.util.*;
import java.io.*;

public class 외판원순회 {

	static int[][] W;
	static int[][] dp;
	static int N;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		W = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				W[i][j]=Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][1<<N];
		
		for(int[] e:dp)
			Arrays.fill(e, INF);
		
		
		for(int i=1;i<N;i++) {
			if(W[0][i]==0)
				continue;
			int visit = 1<<0;
			//0 -> 이동하는 거의 최솟값은
			dp[0][visit]=Math.min(dp[0][visit], tsp(i,visit|(1<<i))+W[0][i]);
		}
		
		System.out.println(dp[0][1]);
		
	}
	
	public static int tsp(int cur,int visited) {
		
		//memoize
		if(dp[cur][visited]<INF)
			return dp[cur][visited];
		
		//이미 다 방문
		if(visited == (1<<N)-1) {
			if(W[cur][0]!=0)
				return W[cur][0];
			else
				return INF;
		}
		for(int i=1;i<N;i++) {
			//길이 없음
			if(W[cur][i]==0)
				continue;
			//길이 있고 아직 방문을 안함
			if((visited & (1<<i))==0)
				dp[cur][visited]=Math.min(dp[cur][visited], tsp(i,visited|(1<<i))+W[cur][i]);
		}
		
		return dp[cur][visited];
	}

}
