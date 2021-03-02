import java.io.*;
import java.util.*;

public class 수강신청 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		//과목 배열 입력
		long[] sub = new long[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int K = Integer.parseInt(st.nextToken());
			long S = 0l;
			
			for(int j=0;j<K;j++) {
				int n = Integer.parseInt(st.nextToken());
				S|=(1l<<n);
			}
			sub[i]=S;
		}
		
		//학생 배열 입력
		int M = Integer.parseInt(bf.readLine());
		long[] stu = new long[M];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int K = Integer.parseInt(st.nextToken());
			long S = 0l;
			
			for(int j=0;j<K;j++) {
				int n = Integer.parseInt(st.nextToken());
				S|=(1l<<n);
			}
			stu[i]=S;
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//학생들이 들을 수 있는 과목 체크 
		
		for(int i=0;i<M;i++) {
			
			long S = stu[i]; //학생들이 비어있는 교시
			int count=0;
			//과목 j를 들을 수 있으면 count++;
			for(int j=0;j<N;j++)
				if((long)(sub[j]&S)==(long)sub[j]);
					count++;
			bw.write(count+"\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
