package 스터디2021;
import java.util.*;
import java.io.*;

public class 배 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//크레인 정보
		int N = Integer.parseInt(bf.readLine());
		int[] crain = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			crain[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(crain);
		
		//박스 정보
		int M = Integer.parseInt(bf.readLine());
		int[] box = new int[M];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++)
			box[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(box);
		
		//옮길 수 없는 경우
		if(crain[N-1]<box[M-1]) {
			System.out.println(-1);
			return;
		}
		
		//6 8 9
		//3 4 1
		//2 2 4 5 7
		//t t f f f 
		
		//index[i] := crain[i]가 들수 있는 최대 무게 박스의 인덱스
		int[] index = new int[N];
		
		int tag=-1;
		for(int k=0;k<N;k++) {
			while((tag+1)<=(M-1) && box[tag+1]<=crain[k])
				tag++;
			index[k]=tag;
		}
		
		//visit[i]=False면 이미 옮긴거
		boolean[] visit = new boolean[M];
		Arrays.fill(visit, true);
		
		int time=0;
		int cnt = M;
		
		while(true) {
		
			time++;
			
			// 6 8 9
			//crain[0] ~ crain[N-1]에 물건을 싣는다.
			for(int k=0;k<N;k++) {
				
				//index[k] 부터 확인 True일때까지
				while(index[k]>=0 && !visit[index[k]])
					--index[k];
			
				if(index[k]==-1) continue;
				
				visit[index[k]]=false;
				--index[k];
				--cnt;
			}
			
			if(cnt==0) break;
			
		}
		
		System.out.println(time);
		
	}

}
