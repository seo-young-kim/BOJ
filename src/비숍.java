import java.io.*;
import java.util.*;

public class 비숍 {
	
	static int N;
	static int[][] map;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		check = new boolean[N][N];
		
		//1.
		bt(0,0,true);
		bt(1,0,false);
		
		System.out.println(max+max2);
		
	}
	
	static int max=0;
	static int max2=0;
	public static void bt(int s,int cnt,boolean binary) {
		
		boolean flag = ((s/N + s%N)%2==0);
		
		if(binary != flag) {
			bt(s+1,cnt,binary);
			return;
		}
		
		if(s>=N*N) {
			if(binary)
				max = Math.max(max, cnt);
			else
				max2 = Math.max(max2, cnt);
			return;
		}
		
		if(map[s/N][s%N]==1 && isPut(s)) {
			check[s/N][s%N]=true;
			bt(s+1,cnt+1,binary);
			check[s/N][s%N]=false;	
		}
		
		bt(s+1,cnt,binary);
		
	}
	
	public static boolean isPut(int s) {
		
		int r = s/N; int c = s%N;
		
		//1.왼쪽 위로
		for(int i=1;i<N;i++) {
			int x = r-i; int y = c-i;
			if(x<0 || y<0)
				break;
			if(check[x][y])
				return false; }
		
		//2.오른쪽 위로
		for(int i=1;i<N;i++) {
			int x = r-i; int y = c+i;
			if(x<0 || y>=N)
				break;
			if(check[x][y])
				return false;}
		
		return true;
	}
}