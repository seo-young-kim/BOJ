import java.io.*;
import java.util.*;

public class ºñ¼ó2 {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && check(i,j)) {
					map[i][j]=2;
					back(i,j,1);
					map[i][j]=1;
				}
			}
		
		System.out.println(max);
	}
	
	static int max=0;
	
	public static boolean check(int x,int y) {
		for(int i=1;i<N;i++) {
			if(x-i>=0 && y-i>=0 && map[x-i][y-i]==2)
				return false;
			if(x-i>=0 && y+i<N && map[x-i][y+i]==2)
				return false;
		}
		return true;
	}
	
	
	public static void back(int x,int y,int cnt) {
		if(x==N-1 && y==N-1) {
			max = Math.max(max, cnt);
			return;
		}
		
		for(int i=x;i<N;i++) {
			int k=0;
			if(i==x)
				k=y;
			for(int j=k;j<N;j++) {
				if(map[i][j]==1 && check(i,j)) {
					map[i][j]=2;
					back(i,j,cnt+1);
					map[i][j]=1;
				}
			}
		}
		max = Math.max(max, cnt);
		
	}

}
