package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 알파벳 {

	static int R,C;
	static char[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0;r<R;r++) {
			String str = bf.readLine();
			for(int c=0;c<C;c++)
				map[r][c]=str.charAt(c);
		}
		
		visit = new boolean[26];
		visit[map[0][0]-'A']=true;
		System.out.println(dfs(0,0,1));
	
	}
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static int dfs(int x,int y,int cnt) {
		
		int max=cnt;
		
		for(int k=0;k<4;k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			if(visit[map[nx][ny]-'A']) continue;
			visit[map[nx][ny]-'A']=true;
			max = Math.max(max,dfs(nx,ny,cnt+1));
			visit[map[nx][ny]-'A']=false;
		}
		
		return max;
	}

}
