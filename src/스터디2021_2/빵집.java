package ½ºÅÍµð2021_2;
import java.io.*;
import java.util.*;
public class »§Áý {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		for(int r=0;r<R;r++) {
			String str = bf.readLine();
			for(int c=0;c<C;c++)
				map[r][c] = (str.charAt(c)=='x')?-1:0;
		}
		
		for(int r=0;r<R;r++)
			map[r][0]=1;
		
		
		//for(int[] e:map)
		//	System.out.println(Arrays.toString(e));
		
		//c -> c+1 Update
		for(int c=0;c<C-1;c++) {
			for(int r=0;r<R;r++) {
				
				if(map[r][c]!=1) continue;
				
				if(r-1>=0 && map[r-1][c+1]==0) {
					map[r-1][c+1]=1; continue;
				}
				
				if(map[r][c+1]==0) {
					map[r][c+1]=1; continue;
				}
				
				if(r+1<R && map[r+1][c+1]==0) {
					map[r+1][c+1]=1; continue;
				}
				
			}
		}
		
		int cnt=0;
		for(int r=0;r<R;r++)
			if(map[r][C-1]==1)
				cnt++;
		System.out.println(cnt);

		for(int[] e:map)
			System.out.println(Arrays.toString(e));
	
		
	}

}
