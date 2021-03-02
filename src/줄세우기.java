import java.io.*;

public class 줄세우기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(bf.readLine());
		
		int[] dp = new int[N];
		
		dp[0]=1;
		int lcs=1;
		
		for(int i=1;i<N;i++) {
			
			int max = 0;
			for(int k=0;k<i;k++)
				if(arr[k]<arr[i])
					max = Math.max(max, dp[k]);
			
			dp[i]=max+1;
			lcs = Math.max(lcs, dp[i]);
		}
		
		System.out.println(N-lcs);
		
		
	}

}
