package 스터디2021;
import java.util.*;
import java.io.*;

public class 드래곤커브 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		boolean[][] map = new boolean[2001][2001];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			//1. 방향 생성
			List<Integer> list = new LinkedList<>();
			generator(list,d,g);
			
			//2. 그대로 그리기
			draw(1000+sx,1000+sy,list,map);
			
		}
		int count=0;
		for(int i=0;i<2000;i++)
			for(int j=0;j<2000;j++) {
				if(!map[i][j] || !map[i+1][j] || !map[i][j+1] || !map[i+1][j+1])
					continue;
				count++;
			}
		System.out.println(count);
		
	}
	
	public static void generator(List<Integer> list, int d, int G){
		
		int[] dir = {1,2,3,0};
		list.add(d);
		for(int g=0;g<G;g++) {
			int len = list.size();
			for(int k=len-1;k>=0;k--) {
				int next = list.get(k);
				list.add(dir[next]);
			}
		}
	}
	
	public static void draw(int sx,int sy,List<Integer> list, boolean[][] map) {
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		Iterator itr = list.iterator();
		
		map[sx][sy]=true;
		int nx = sx;
		int ny = sy;
		while(itr.hasNext()) {
			int k = (Integer)itr.next();
			nx +=dx[k];
			ny +=dy[k];
			map[nx][ny]=true;
		}
	}
}