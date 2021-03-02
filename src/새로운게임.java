import java.util.*;
import java.io.*;

class Horse{
	int x,y,d;
	Horse(int x,int y,int d){
		this.x = x;this.y = y;this.d = d;
	}
}

public class ���ο���� {

	static int[][] map;
	static int N;
	static int K;
	static Horse[] horse;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		horse = new Horse[K];
		list = new List[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				list[i][j]=new LinkedList<>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			horse[i]=new Horse(x,y,d);
			list[x][y].add(i);
		}
		
		int turn=0;
		
		while(true) {
			
			turn++;
			if(!move()) {
				System.out.println(turn);
				break;
			}
			if(turn>=1000) {
				System.out.println(-1);
				break;
			}
		}
		
	}
	
	static List[][] list;
	
	public static boolean move() {
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		
		for(int i=0;i<K;i++) {
		
			int x = horse[i].x;
			int y = horse[i].y;
			int d = horse[i].d;
			
			//1.�� i�� ���� �Ʒ� �ִ� ���� �ƴϸ� ����
			if((Integer)list[x][y].get(0)!=i)
				continue;
			
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			//���̰ų� �Ķ����̸� ���� �ٲ�
			if(nx<0 || ny<0 || nx>=N || ny>=N ||  map[nx][ny]==2) {
				if(d%2==0) d++; else d--;
				nx = x+dx[d];
				ny = y+dy[d];
			}
			
			// �׷��µ��� �׷��� ���� �ٽ� �ٲ�
			if(nx<0 || ny<0 ||  nx>=N || ny>=N || map[nx][ny]==2)
				continue;
			
			//���̳� �������̸� ���� �������� 4�̻��̸� ����
			if(list[nx][ny].size()+list[x][y].size()>=4)
				return false;
			
			horse[i].d=d;
			
			//���
			if(map[nx][ny]==0) {
				
				for(int k=0;k<list[x][y].size();k++) {
					int next = (Integer)list[x][y].get(k);
					
					list[nx][ny].add(next);
					horse[next].x = nx;
					horse[next].y = ny;
					
				}
				list[x][y].removeAll(list[x][y]);
				
			}else { //������
				for(int k=list[x][y].size()-1;k>=0;k--) {
					int next = (Integer)list[x][y].get(k);
					list[nx][ny].add(next);
					horse[next].x = nx;
					horse[next].y = ny;
					
				}
				list[x][y].removeAll(list[x][y]);
			}
			
		}
		return true;
	}
}