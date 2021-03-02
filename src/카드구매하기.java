import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드구매하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] pstr = bf.readLine().split(" ");
		int[] p = new int[N+1];
		for(int i=1;i<=N;i++)
			p[i]=Integer.parseInt(pstr[i-1]);
		
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=i;j++)
				if(dp[i]<p[j]+dp[i-j])
					dp[i]=p[j]+dp[i-j];
		
		System.out.println(dp[N]);
	}

}
