package 단기간성장;
import java.util.*;
import java.io.*;

public class 단어섞기 {
	
	static char[] str1;
	static char[] str2;
	static char[] str3;
	static int N,M,K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=C;i++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			str1 = st.nextToken().toCharArray();
			str2 = st.nextToken().toCharArray();
			str3 = st.nextToken().toCharArray();
			N = str1.length;
			M = str2.length;
			K = str3.length;
			dp = new int[N+1][M+1];
			for(int[] e:dp)
				Arrays.fill(e, -1);
			
			bw.write("Data set "+i+": ");
			
			if(solve(0,0,0)==1)
				bw.write("yes");
			else
				bw.write("no");
			
			bw.write("\n");
			bw.flush();
		}
		
		bw.close();
		
	}
	
	
	public static int solve(int i,int j,int k) {
		
		//k가 넘어갔으면 다 채워진거, 1 넣고 return
		if(k>=K) {
			dp[i][j]=1;
		}else if(dp[i][j]==-1){
		
			//시도1
			if(i<N && str1[i]==str3[k])
				if(solve(i+1,j,k+1)==1)
					dp[i][j]=1;
			
			//시도2
			if(dp[i][j]==-1 && j<M && str2[j]==str3[k])
				if(solve(i,j+1,k+1)==1)
					dp[i][j]=1;
			
			//안됨 -> false
			if(dp[i][j]==-1)
				dp[i][j]=0;
			
		}
		
		return dp[i][j];
	}
}