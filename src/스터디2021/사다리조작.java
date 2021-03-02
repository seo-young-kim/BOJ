package 스터디2021;
import java.io.*;
import java.util.*;

public class 사다리조작 {

	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//M 세로선
		M = Integer.parseInt(st.nextToken());
		// 입력받는
		int H = Integer.parseInt(st.nextToken());
		// 그을 수 있는 가로선
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M-1];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(bf.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		
		bt(0,0);
		
		if(min==10)
			min=-1;
		System.out.println(min);
		
	}
	

	static int min = 10;
	
	
	public static void bt(int s,int cnt) {
		
				
		//지금 cnt개 만큼 놓은 상태 만일 가능하면, 더이상 안해도 됨
		if(check()) {
			min = Math.min(min, cnt);
			return;
		}
		
		//이미 cnt개만으로 가능 -> 굳이 안해봐도되자나?
		if(min<=cnt+1)
			return;
				
		//3개이상 놓을 수 없음
		if(cnt>=3)
			return;
		
		for(int i=s;i<N*(M-1);i++) {
			
			int x = i/(M-1);
			int y = i%(M-1);
			
			if(map[x][y]==1) continue;
			
			if(y-1>=0 && map[x][y-1]==1)
				continue;
			if(y+1<M-1 && map[x][y+1]==1)
				continue;
			
			//양옆에 없음
			map[x][y]=1;
			bt(s+1,cnt+1);
			map[x][y]=0;
			
		}
		
	}
	
	public static boolean check() {
		
		int[] num = new int[M];
		for(int i=1;i<M;i++)
			num[i]=i;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M-1;j++) {
				if(map[i][j]==1) {
					int temp = num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
			}
		
		for(int i=0;i<M;i++)
			if(num[i]!=i) return false;
		return true;
	}

}
