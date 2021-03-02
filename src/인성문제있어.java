import java.util.*;
import java.io.*;

public class 인성문제있어 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Tc = Integer.parseInt(bf.readLine());
		
		while(Tc-->0) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
			int O = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			
			int[] s = new int[2];
			s[0] = Integer.parseInt(st.nextToken())-1;
			s[1] = Integer.parseInt(st.nextToken())-1;
			
			int[] e = new int[2];
			e[0] = Integer.parseInt(st.nextToken())-1;
			e[1] = Integer.parseInt(st.nextToken())-1;
				
			while(O-->0) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());
				map[x][y]=w;
			}
			
			
			if(maze(H,W,map,F,s,e))
				bw.write("잘했어!!");
			else 
				bw.write("인성 문제있어??");
			
		}
		bw.flush();
		bw.close();
		
	}
	
	public static boolean maze(int H,int W,int[][] map,int F,int[] s,int[] e) {
		
		//x,y까지 도달 했을때 남아있는 힘의 크기
		int[][] dp = new int[H][W];
		for(int[] arr:dp)
			Arrays.fill(arr, -1);
		
		dp[s[0]][s[1]]=F;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {s[0],s[1],F});
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			
			
			
			//어차피 이동 못함
			if(cur[2]<=0) continue;
			
			int p = cur[2];
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0 || nx>=H || ny<0 || ny>=W)
					continue;
				
				//점프 못함
				if(map[nx][ny]-map[x][y]>p)
					continue;
					
				//굳이 갈 필요가 없음
				if(dp[nx][ny]>=p-1)
					continue;
				
				que.offer(new int[] {nx,ny,p-1});
				dp[nx][ny]=p-1;
				
			}
		}
		
		
		for(int[] arr:dp)
			System.out.println(Arrays.toString(arr));
		
		if(dp[e[0]][e[1]]>=0) return true;
		
		return false;
	}

}