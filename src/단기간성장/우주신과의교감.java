package 단기간성장;
import java.util.*;
import java.io.*;

public class 우주신과의교감 {

	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] location = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			location[i][0] = Integer.parseInt(st.nextToken());
			location[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//거리 배열 adj
		double[][] adj = new double[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int dx = location[i][0]-location[j][0];
				int dy = location[i][1]-location[j][1];
				adj[i][j] = Math.sqrt(dx*dx+dy*dy);
				adj[j][i]=adj[i][j];
			}
		}
		
		//미리 연결되어 있는 배열 map
		int[][] map = new int[N][N];
		double answer = 0.0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			map[n1][n2]=1;
			map[n2][n1]=1;
			answer +=adj[n1][n2];
		}
		
		
		//Prim()
		boolean[] S = new boolean[N];
		
		
		
	}

}
