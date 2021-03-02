import java.io.*;
import java.util.*;

public class 영역구하기 {

	static int[][] map;
	static int M,N;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			
			for(int x=sx;x<ex;x++)
				for(int y=sy;y<ey;y++)
					map[x][y]=-1;
		}
		
		//for(int[] e:map)
			//System.out.println(Arrays.toString(e));
		
		List<Integer> list = new LinkedList<>();
		
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				if(map[i][j]==0)
					list.add(bfs(i,j));
		
		int[] temp = new int[list.size()];
		int count=0;
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
			temp[count++]=(int)itr.next();
		}
		System.out.println(temp.length);
		Arrays.sort(temp);
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
	}
	
	public static int bfs(int i,int j) {
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i,j});
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int count=0;
		
		while(!que.isEmpty()) {
			
			int[] now = que.poll();
			int x = now[0];
			int y = now[1];
			
			if(map[x][y]!=0)
				continue;
			
			map[x][y]=1;
			count++;
			
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx<0 || ny<0 || nx>=M || ny>=N)
					continue;
				if(map[nx][ny]==0)
					que.offer(new int[] {nx,ny});
			}
			
		}
		
		
		
		return count;
		
	}

}
