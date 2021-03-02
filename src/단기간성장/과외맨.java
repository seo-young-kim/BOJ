package 단기간성장;
import java.util.*;
import java.io.*;

public class 과외맨 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		//타일 숫자 판
		int[][] number = new int[N][N*2];
		
		//각 위치에 있는 타일이 몇번쨰 타일인지 표기
		int[][] map = new int[N][N*2];
		
		int cnt=1;
		
		for(int i=0;i<N;i++) {
			int k = (i%2==0)?0:1;
			int end =(i%2==0)?N*2:N*2-1;
			for(int j=k;j<end;j+=2) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				number[i][j]=l;
				number[i][j+1]=r;
				map[i][j]=cnt;
				map[i][j+1]=cnt;
				cnt++;
			}
		}
		
		//BFS
		int[][] dp = new int[N][N*2];
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		dp[0][0]=1;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int[] mem = new int[cnt];
		
		//가장 큰 타일의 번호
		int max=0;
		int mx=0,my=0;
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			
			//도달 할 수 있는 가장 큰 타일의 번호
			if(max<map[x][y]) {
				max = map[x][y];
				mx=x; my=y;
			}
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				//범위를 벗어나면 안함
				if(nx<0 || ny<0 || nx>=N || ny>=N*2 || number[nx][ny]==0) continue;
				//이미 들린 곳으면 안함
				if(dp[nx][ny]!=0 && dp[nx][ny]<(dp[x][y]+1))
					continue;
				
				//같은 타일
				if(map[x][y]==map[nx][ny]) {
					dp[nx][ny]=dp[x][y];
					que.offer(new int[] {nx,ny});
					continue;
				}
				//다른 타일이면 같은 숫자여야 넘어갈 수 있음
				if(number[nx][ny]==number[x][y]) {
					int tile = map[nx][ny];
					mem[tile]=map[x][y];
					dp[nx][ny]=dp[x][y]+1;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		//출력
		System.out.println(dp[mx][my]);
		System.out.println(cnt);
		int[] answer = new int[2*cnt];
		int index = 0;
		answer[0]=max;
		int next = max;
		System.out.println(max);
		while(next>1) {
			next = mem[next];
			answer[++index]=next;
		}
		
		for(int a=index;a>=0;a--)
			System.out.print(answer[a]+" ");
			
			
	}
	

}
