package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 가스관 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		//위 오 아래 왼
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int[] src = new int[2];
		int[] dst = new int[2];
		
		
		for(int r=0;r<R;r++) {
			String str = bf.readLine();
			for(int c=0;c<C;c++) {
				char next = str.charAt(c);
				switch(next) {
					case 'M':
						src[0]=r;
						src[1]=c;
						break;
					case 'Z':
						dst[0]=r;
						dst[1]=c;
						break;
					//	위:0 오:1 아래:2 왼:3
					case '.':
						map[r][c]=0;
					default:
						map[r][c]=dir(next);
						break;
				}	
			}
		}
		//빈 곳 찾음
		int[] answer = findBlock(map,src,dst);
		//answer로 향하는 애 찾음
		System.out.print((answer[0]+1)+" "+(answer[1]+1)+" ");
		for(int k=0;k<4;k++) {
			int nx = answer[0]+dx[k];
			int ny = answer[1]+dy[k];
			if(nx<0 || ny<0 || nx>=R || ny>=C || map[nx][ny]==0) continue;
			
			for(int j=0;j<4;j++) {
				if((map[nx][ny]&(1<<j))!=0) {
					int cx = nx+dx[j];
					int cy = ny+dy[j];
					if(cx==answer[0] && cy==answer[1]) {
						map[answer[0]][answer[1]]|=(1<<k);
						break;
					}
				}
			}
		}
		
		//map[][]에 숫자 담겨있는데 걔가 누군지 찾아야함
		char[] who = {'|','-','+','1','2','3','4'};
		for(int i=0;i<7;i++)
			if(dir(who[i])==map[answer[0]][answer[1]])
				System.out.println(who[i]);
			
	}
	
	public static int dir(char d) {
		
		int bit=0;
		switch(d) {
		//	위:0 오:1 아래:2 왼:3
		case '|':
			bit|=(1<<0);
			bit|=(1<<2);
			break;
		case '-':
			bit|=(1<<1);
			bit|=(1<<3);
			break;
		case '+':
			bit|=(1<<0);
			bit|=(1<<1);
			bit|=(1<<2);
			bit|=(1<<3);
			break;
		case '1':
			bit|=(1<<1);
			bit|=(1<<2);
			break;
		case '2':
			bit|=(1<<0);
			bit|=(1<<1);
			break;
		case '3':
			bit|=(1<<0);
			bit|=(1<<3);
			break;
		case '4':
			bit|=(1<<2);
			bit|=(1<<3);
			break;
		}
		return bit;
	}
	
	
	public static int[] findBlock(int[][] map,int[] src,int[] dst) {
		
		int R = map.length;
		int C = map[0].length;
		//위 오 아래 왼
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		boolean[][] visit = new boolean[R][C];
		Queue<int[]> que = new LinkedList<>();
		visit[src[0]][src[1]]=true;
		visit[dst[0]][dst[1]]=true;
		for(int k=0;k<4;k++) {
			int nx = src[0]+dx[k];
			int ny = src[1]+dy[k];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			if(map[nx][ny]!=0) {
				que.offer(new int[] {nx,ny});
				visit[nx][ny]=true;
			}
		}
		
		int[] answer = new int[2];
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int cx = cur[0];
			int cy = cur[1];
			int dir = map[cx][cy];
			for(int k=0;k<4;k++) {
				if( (dir&(1<<k)) !=0) {
					
					int nx = cx+dx[k];
					int ny = cy+dy[k];
					if(visit[nx][ny]) continue;
					
					if(map[nx][ny]==0) {
						return new int[] {nx,ny};
					}else {
						visit[nx][ny]=true;
						que.offer(new int[] {nx,ny});
					}
					
				}
			}
		}
		
		return answer;

	}

}
