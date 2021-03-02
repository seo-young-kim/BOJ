import java.io.*;
import java.util.*;

public class 최소비용구하기 {

	static final int MAX = 100001;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		int[][] map = new int[N][N];
		
		for(int[] e:map)
			Arrays.fill(e, MAX*N);
		
		for(int i=0;i<N;i++)
			map[i][i]=0;
		
		while(M-->0) {
			String[] str = bf.readLine().split(" ");
			int i = Integer.parseInt(str[0])-1;			
			int j = Integer.parseInt(str[1])-1;
			map[i][j]=Math.min(map[i][j], Integer.parseInt(str[2]));
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
		
		System.out.println(map[start][end]);
		
		
	}

}
