package 스터디2021;
import java.util.*;
import java.io.*;

public class 구간나누기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(bf.readLine());
		
		int[][] sub = new int[N][N];
		
		for(int i=0;i<N;i++) {
			//sub[i][]
			sub[i][i]=arr[i];
			//for(int j=i+1;j<N;j++)
				
		}
		
		
	}

}
