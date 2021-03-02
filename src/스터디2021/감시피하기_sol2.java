package 스터디2021;
import java.io.*;
import java.util.*;

public class 감시피하기_sol2 {

	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=st.nextToken().charAt(0);
		}
		
		//bruteforce
		bt(0,0);
		System.out.println("NO");
		
	}
	
	
	public static void bt(int s,int cnt) {
		
		if(cnt==3) {
			
			if(check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		
		for(int i=s;i<N*N;i++) {
			int x = i/N;
			int y = i%N;
			if(map[x][y]=='X') {
				map[x][y]='O';
				bt(i+1,cnt+1);
				map[x][y]='X';
			}
		}
		
	}
	
	
	public static boolean check() {
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(map[i][j]=='T')
					if(!avoid(i,j))
						return false;
		
		return true;
	}
	
	public static boolean avoid(int x, int y) {
		
		//x,y자리에 있는 T가 학생들을 볼 수 없으면 (피하기 성공) true, 볼 수 있으면(실패) false 리턴
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int k=0;k<4;k++) {
			
			int cx = x; int cy = y;
			while(true) {
				
				cx +=dx[k];
				cy +=dy[k];
				if(cx<0 || cy<0 || cx>=N || cy>=N)
					break;
				if(map[cx][cy]=='O')
					break;
				if(map[cx][cy]=='T')
					break;
				if(map[cx][cy]=='S')
					return false;
			}
			
		}
		
		return true;
	}

}
