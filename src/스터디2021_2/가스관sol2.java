package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 가스관sol2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		String str1="   | 12  43 -  +";
		char[] pipe = new char[16];
		for(int k=0;k<17;k++)
			pipe[k]=str1.charAt(k);
		
		for(int r=0;r<R;r++) {
			String str = bf.readLine();
			for(int c=0;c<C;c++)
				map[r][c] = str.charAt(c);
		}
		
		//위 아래 왼 오
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				
				if(map[r][c]=='.') {
					
					int l=0;
					for(int k=0;k<4;k++) {
						
						int nx = r+dx[k];
						int ny = c+dy[k];
						if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
						for(int s=0;s<16;s++) {
							if(pipe[s]==map[nx][ny]) {//파이프가가 있음
								if((s&(1<<(k^1)))!=0) {
									
									l|=(1<<k);
									System.out.println("s="+Integer.toBinaryString(s));
									System.out.println("k="+k);
									System.out.println("k^1="+(k^1));
									
									System.out.println("1<<(k^1)="+Integer.toBinaryString(1<<(k^1)));
									System.out.println("1<<(k)="+Integer.toBinaryString(1<<(k)));
									
									System.out.println((s&(1<<(k^1))));
									break;
								}
							}
						}	
					}
					if(l>0) {
						System.out.println((r+1)+" "+(c+1)+" "+pipe[l]);
						return;
					}
				}
				
			}
		}
			
	}
	
}
