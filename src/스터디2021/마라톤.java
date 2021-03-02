package 스터디2021;
import java.util.*;
import java.io.*;

public class 마라톤 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] point = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			point[i][0]=Integer.parseInt(st.nextToken());
			point[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int[] prefix = new int[N];
		int[] suffix = new int[N];
		
		//prefix[i] = 0~i까지의 맨핸튼거리
		for(int i=1;i<N;i++) {
			int dx = Math.abs(point[i-1][0]-point[i][0]);
			int dy = Math.abs(point[i-1][1]-point[i][1]);
			prefix[i]=prefix[i-1] + (dx+dy);
		}
		
		// suffix[i] = i~N-1까지의 맨핸튼거리
		for(int i=N-2;i>0;i--) {
			int dx = Math.abs(point[i][0]-point[i+1][0]);
			int dy = Math.abs(point[i][1]-point[i+1][1]);
			suffix[i]=suffix[i+1] + (dx+dy);
		}
		
		int min = 987654321;
		for(int k=1;k<N-2;k++) {
			
			int dx = Math.abs(point[k-1][0]-point[k+1][0]);
			int dy = Math.abs(point[k-1][1]-point[k+1][1]);
			
			min = Math.min(min,prefix[k-1]+dx+dy+suffix[k+1]);
			
		}
		
		System.out.println(min);
		
	}

}
