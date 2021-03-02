import java.util.*;
import java.io.*;

public class 소용돌이예쁘게출력하기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String[] rangeStr = bf.readLine().split(" ");
		int r1 = Integer.parseInt(rangeStr[0]);
		int c1 = Integer.parseInt(rangeStr[1]);
		int r2 = Integer.parseInt(rangeStr[2]);
		int c2 = Integer.parseInt(rangeStr[3]);
		
		int[][] map = new int[r2-r1+1][c2-c1+1];
		int count = (r2-r1+1)*(c2-c1+1);
		
		//l=0 일때 초기화
		int l=1,r=0,c=0;
		int n=1;
		
		if(r1<=r && r<=r2 && c1<=c && c<=c2) {
			map[r-r1][c-c1]=n;
			count--;
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
outer:	while(count>0) {
			
			//다음 소용돌이 
			c++;
			l+=2;
			n++;
			if(r1<=r && r<=r2 && c1<=c && c<=c2) {
				map[r-r1][c-c1]=n;
				count--;
			}
			
			for(int k=0;k<4;k++) {
				
				int x = l-1;
				if(k==0) x=l-2;
				
				for(int i=0;i<x;i++) {
					r +=dx[k];c +=dy[k];
					n++;
					if(r1<=r && r<=r2 && c1<=c && c<=c2) {
						map[r-r1][c-c1]=n;
						count--;
					}
					if(count<=0)
						break outer;
				}
			}
		}
		     
		String max = String.valueOf(n);
		int len = max.length();
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				
				String now = String.valueOf(map[i][j]);
				for(int a=0;a<len-now.length();a++)
					System.out.print(" ");
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
