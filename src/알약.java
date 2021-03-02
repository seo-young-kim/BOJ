import java.io.*;

public class ¾Ë¾à {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[31][31];
		
		for(int N=1;N<=30;N++)
			for(int K=N;K>=0;K--) {
				if(N==K)
					dp[N][K]=1l;
				else if(K==0)
					dp[N][K]=dp[N][1];
				else
					dp[N][K]=dp[N][K+1]+dp[N-1][K-1];		
			}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			
			int N = Integer.parseInt(bf.readLine());
			if(N==0)
				break;
			bw.write(dp[N][0]+"\n");
			
		}

		bw.flush();
		bw.close();
		
	}

}
