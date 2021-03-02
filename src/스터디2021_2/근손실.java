package 스터디2021_2;
import java.io.*;
import java.util.*;
public class 근손실 {

	static int N;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken())-K;
		
		//cnt,sum
		System.out.println(bt(0,0));
		
	}
	// 3  7  5
	//-1  3  1
	
	public static int bt(int cnt,int sum) {
		
		if(cnt==N)
			return 1;
		
		
		int answer = 0;
		for(int i=0;i<N;i++)
			if(!visit[i] && sum+arr[i]>=0) {
				visit[i]=true;
				answer +=bt(cnt+1,sum+arr[i]);
				visit[i]=false;
			}
		return answer;
	}

}
