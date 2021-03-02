package 단기간성장;
import java.util.*;
import java.io.*;

public class 여행가자 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int[][] map = new int[N][N];
		int Max = 987654321;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				int w =Integer.parseInt(st.nextToken());
				if(i==j)
					map[i][j]=1;
				else
					map[i][j]=(w==0)?Max:1;
			}
		}
		
		//플로이드
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
				
		
		//for(int[] e:map)
			//System.out.println(Arrays.toString(e));
		
		int[] travel = new int[M];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++)
			travel[i]=Integer.parseInt(st.nextToken())-1;
		
		//Yes Or No 출력
		
		boolean chk = true;
		
		for(int i=0;i<(M-1);i++)
			if(map[travel[i]][travel[i+1]]==Max) {
				chk = false; break;
			}
		
		String answer = (chk)?"YES":"NO";
		System.out.print(answer);
	}

}
