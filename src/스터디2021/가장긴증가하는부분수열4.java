package 스터디2021;
import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열4 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		//dp[i] ; i까지의 가장 긴 증가하는 부분 수열의 길이
		int[] dp = new int[N];
		
		//record[i] ; 가장 긴 증가하는 부분 수열이게 하는 전 index
		int[] record = new int[N];
		Arrays.fill(record, -1);
		
		dp[0]=1;
		int max = 1;
		int maxIndex = 0;
		
		//dp[i] : i까지의 가장
		
		// 0  1  2  3  4  5
		//10 20 10 30 20 50
		// 1  2  1  3  2  4
		//-1              3   
		
		for(int i=1;i<N;i++) {
			int maxLen=0;
			int preIndex=-1;
			//arr[i] 보다 작은 애들 중 dp[i]가 가장 큰 녀석
			for(int j=0;j<i;j++) {
				if(arr[j]>=arr[i]) continue;
				if(dp[j]>maxLen) {
					maxLen=dp[j];
					preIndex=j;
				}
			}
			dp[i]=maxLen+1;
			record[i]=preIndex;
			if(max<dp[i]) {
				max = dp[i];
				maxIndex=i;
			}
		}
		
		//max 출력
		System.out.println(max);
		int[] sub = new int[max];
		//sub 찾기
		int index = maxIndex;
		int k=max-1;
		
		while(index!=-1) {
			sub[k]=arr[index];
			index=record[index];
			k--;
		}
		
		
		//sub 출력
		for(int i=0;i<max;i++)
			System.out.print(sub[i]+" ");
	}

}
