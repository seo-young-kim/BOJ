package ½ºÅÍµð2021;
import java.util.*;
import java.io.*;

public class LCS {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = bf.readLine().toCharArray();
		char[] str2 = bf.readLine().toCharArray();
		
		int N = str1.length;
		int M = str2.length;
		
		int[][] dp = new int[N+1][M+1];
		
		for(int i=N-1;i>=0;i--)
			for(int j=M-1;j>=0;j--)
				//initial
				if(j==M-1 || i==N-1) {
					dp[i][j]=(str1[i]==str2[j])?1:(Math.max(dp[i+1][j], dp[i][j+1]));
					
				}
				else {
					dp[i][j]=(str1[i]==str2[j])?(dp[i+1][j+1]+1):(Math.max(dp[i+1][j], dp[i][j+1]));
				}
		
		System.out.println(dp[0][0]);
		
	}

}
