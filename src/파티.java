import java.util.*;
import java.io.*;

public class 파티 {

	static int N,X;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2])-1;
		
		int[][][] map = new int[2][N][N];
		
		while(M-->0) {
			str = bf.readLine().split(" ");
			int S = Integer.parseInt(str[0])-1;
			int E = Integer.parseInt(str[1])-1;
			int W = Integer.parseInt(str[2]);
			map[0][S][E]=W;
			map[1][E][S]=W;
		}
		
		int[] arr1 = dijk(map[0]);
		int[] arr2 = dijk(map[1]);
		
		int max=0;
		
		for(int i=0;i<N;i++)
			max = Math.max(max, arr1[i]+arr2[i]);
		
		System.out.println(max);
		
	}
	
	static final int MAX = 999999999;
	
	public static int[] dijk(int[][] map) {
		
		int[] dist = new int[N];
		Arrays.fill(dist, MAX);
		
		boolean[] S = new boolean[N];
		PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		que.offer(new int[] {X,0});
		
		for(int a=0;a<N;a++) {
			//1. S에 포함 되지 않은 것 중 dist가 최소인 애 찾기
			int[] next = que.poll();
			
			while(S[next[0]])
				next = que.poll();
			
			//2. Relax & 포함시키기
			dist[next[0]]=next[1];
			S[next[0]]=true;
			
			for(int i=0;i<N;i++) {
				if(map[next[0]][i]!=0)
					que.offer(new int[] {i,Math.min(dist[i], next[1] + map[next[0]][i])});
			}	
		}
		return dist;
	}

}
