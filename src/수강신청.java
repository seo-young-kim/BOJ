import java.io.*;
import java.util.*;

public class ������û {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		//���� �迭 �Է�
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
		
		//�л� �迭 �Է�
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
		//�л����� ���� �� �ִ� ���� üũ 
		
		for(int i=0;i<M;i++) {
			
			long S = stu[i]; //�л����� ����ִ� ����
			int count=0;
			//���� j�� ���� �� ������ count++;
			for(int j=0;j<N;j++)
				if((long)(sub[j]&S)==(long)sub[j]);
					count++;
			bw.write(count+"\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
