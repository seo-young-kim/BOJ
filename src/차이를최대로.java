import java.util.*;
import java.io.*;

public class 차이를최대로 {
	
	static int N;
	static int[] numbers;
	static int max=0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			numbers[i]=Integer.parseInt(st.nextToken());
		
		boolean[] chk = new boolean[N];
		int[] S = new int[N];
		
		bt(0,chk,S);
		
		System.out.println(max);
	}
	
	public static void bt(int cnt,boolean[] chk,int[] S) {
		
		if(cnt==N) {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=Math.abs(S[i]-S[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!chk[i]) {
				S[cnt]=numbers[i];
				chk[i]=true;
				bt(cnt+1,chk,S);
				chk[i]=false;
			}
		}
	}
}