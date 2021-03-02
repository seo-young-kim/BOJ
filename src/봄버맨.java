import java.util.*;
import java.io.*;

public class 봄버맨 {

	static int R,C;
	static char[][][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		map = new char[2][R][C];
		
		for(int i=0;i<R;i++) {
			String str = bf.readLine();
			for(int j=0;j<C;j++)
				map[0][i][j]=str.charAt(j);
		}
		
		if(N==1) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					System.out.print(map[0][i][j]);
				System.out.println();
			}
			return;
		}
		
		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					System.out.print("O");
				System.out.println();
			}
			return;
		}

		//N>=3
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		int index=0;
		
		for(int time=3;time<=N;time+=2) {
			
			//map[index2][] fill
			int index2 = (index+1)%2;
			
			for(int x=0;x<R;x++)
				for(int y=0;y<C;y++)
					map[index2][x][y]='O';
			
			for(int i=0;i<R;i++)
				for(int j=0;j<C;j++)
					
					if(map[index][i][j]=='O') {
						map[index2][i][j]='.';
						for(int k=0;k<4;k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
							map[index2][nx][ny]='.';
						}
					}
			
			//터지고 난 상태가 index2 
			
			index=index2;
		}
	
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				System.out.print(map[index][i][j]);
			System.out.println();
		}
		return;
	}

}
