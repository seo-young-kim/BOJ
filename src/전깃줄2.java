import java.util.*;
import java.io.*;
//https://yhwan.tistory.com/21
//참고.. 너무 어려웠음 엉엉
public class 전깃줄2 {

	//dp배열
	static int[] dp;
	//dp배열에 기록되는 index배열
	static int[] record;
	//기록될때 자기 앞에 누가 있었는지 기록
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0]=a;
			arr[i][1]=b;
		}
		
		Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
	
		dp = new int[N];
		record = new int[N];
		int index=1;
		dp[0]=0;
		dp[index]=arr[0][1];
		record[0]=1;
		
		for(int i=1;i<N;i++) {
			
			if(dp[index]<arr[i][1]) {
				dp[++index]=arr[i][1];
				record[i]=index;
			}else {
				//lowerbound를 찾아서 대체한다.
				int lwb = find(0,index,arr[i][1]);
				dp[lwb+1]=arr[i][1];
				record[i]=lwb+1;
			}
			
		}
		
		bw.write(N-index+"\n");
		
		
		boolean[] lis = new boolean[N];
		
		for(int i=N-1;i>=0;i--) {
			
			if(record[i]==index) {
				lis[i]=true;
				index--;
			}
			
		}
		
		for(int i=0;i<N;i++)
			if(!lis[i]) {
				bw.write(arr[i][0]+"\n");
		bw.flush();}
		bw.close();
	}
	
	public static int find(int s,int e,int num) {
		
		//1.lower bound를 찾는다.
		while(s<=e) {
			int index = (s+e)/2;
			int mid = dp[index];
			
			if(s==e) {
				if(mid<num) return index;
				else return index-1;
			}
			if(mid<num) s=index+1;
			else e=index-1;
		}
		
		return e;

	}
}
