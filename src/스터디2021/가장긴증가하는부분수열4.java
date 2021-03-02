package ���͵�2021;
import java.util.*;
import java.io.*;

public class ����������ϴºκм���4 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		//dp[i] ; i������ ���� �� �����ϴ� �κ� ������ ����
		int[] dp = new int[N];
		
		//record[i] ; ���� �� �����ϴ� �κ� �����̰� �ϴ� �� index
		int[] record = new int[N];
		Arrays.fill(record, -1);
		
		dp[0]=1;
		int max = 1;
		int maxIndex = 0;
		
		//dp[i] : i������ ����
		
		// 0  1  2  3  4  5
		//10 20 10 30 20 50
		// 1  2  1  3  2  4
		//-1              3   
		
		for(int i=1;i<N;i++) {
			int maxLen=0;
			int preIndex=-1;
			//arr[i] ���� ���� �ֵ� �� dp[i]�� ���� ū �༮
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
		
		//max ���
		System.out.println(max);
		int[] sub = new int[max];
		//sub ã��
		int index = maxIndex;
		int k=max-1;
		
		while(index!=-1) {
			sub[k]=arr[index];
			index=record[index];
			k--;
		}
		
		
		//sub ���
		for(int i=0;i<max;i++)
			System.out.print(sub[i]+" ");
	}

}
