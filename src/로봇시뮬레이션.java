import java.util.*;
import java.io.*;

class Robot{
	int x,y,d;
	Robot(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}

public class ·Îº¿½Ã¹Ä·¹ÀÌ¼Ç {
	
	static int[][] map;
	static Robot[] robot;
	static int X,Y;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		robot = new Robot[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = X-Integer.parseInt(st.nextToken());
			char D = st.nextToken().charAt(0);
			int d=-1;
			switch(D) {
				case 'N': d=0; break;
				case 'E': d=1; break;
				case 'S': d=2; break;
				case 'W': d=3; break;
			}
			robot[i]=new Robot(x,y,d);
			map[x][y]=i;
		}
		
		boolean flag = true;
		
		while(M-->0) {
			
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			char I = st.nextToken().charAt(0);
			int K = Integer.parseInt(st.nextToken());
			
			if(!move(R,I,K)) {
				flag = false;
				break;
			}
		}
		
		if(flag)
			System.out.println("OK");
		
	}
	public static boolean move(int R,char I,int k) {
				 // N  E S W
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int x = robot[R].x;
		int y = robot[R].y;
		int d = robot[R].d;
		
		switch(I) {
		
			case 'L': 
				while(k-->0)
					robot[R].d = (robot[R].d+3)%4;
				
				System.out.println("X="+x+" Y="+y);
				break;
				
			case 'R':
				while(k-->0)	
					robot[R].d = (robot[R].d+1)%4;
				System.out.println("X="+x+" Y="+y);
				
				break;
				
			case 'F':
				
				while(k-->0) {
					x = x+dx[d];
					y = y+dy[d];
					System.out.println("X="+x+" Y="+y);
					if(x<0 || y<0 || x>=X || y>=Y) {
						System.out.println("Robot "+R+" crashes into the wall");
						return false;
					}
					
					if(map[x][y]!=0) {
						System.out.println("Robot "+R+" crashes into robot "+map[x][y]);
						return false;
					}
				}
				
				map[robot[R].x][robot[R].y] = 0;
				map[x][y]=R;
				robot[R].x=x;
				robot[R].y=y;
				break;
		}
		
		return true;
	}

}