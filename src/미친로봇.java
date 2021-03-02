import java.io.*;
import java.util.*;

public class ¹ÌÄ£·Îº¿ {

	static int N;
	// µ¿ ¼­ ³² ºÏ
	static double[] proba;
	static boolean[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		proba = new double[4];
		map = new boolean[50][50];
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		
		//È®·ü
		for(int i=0;i<4;i++) {
			int pp = Integer.parseInt(str[i+1]);
			proba[i]=(double)pp/(100.0);
		}
		
		map[25][25]=true;
		bt(25,25,0,1.0);
		
		System.out.println(1-answer);
		
	}
	
	static double answer=0;//°ãÄ¡´Â
	
	public static void bt(int x,int y, int cnt,double p) {
		
		if(cnt>=N)
			return;
		
		
		for(int k=0;k<4;k++) {
			
			int nx = x+dx[k];
			int ny = y+dy[k];
			double pro = p*proba[k];
			if(map[nx][ny]) {
				answer+=pro;
				continue;
			}else {
				map[nx][ny]=true;
				bt(nx,ny,cnt+1,pro);
				map[nx][ny]=false;
			}
		}
		
	}

}
