package �ܱⰣ����;
import java.util.*;
import java.io.*;

public class �ſＳġ {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		char[][] map = new char[N][N];
		int[][] dp = new int[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
					dp[i][j]=-1;
		int ex=0;int ey=0;
		for(int i=0;i<N;i++) {
			String str = bf.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='#') {
					ex=i;ey=j;
				}
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		
				//0 1 2 3
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		// 
outer:	for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(map[i][j]=='#') {
					dp[i][j]=0;
					//������ �������� �� ���������� �� �� ����
					// �ű�� dp = 0���� ����
					//���ٰ� �ſ� ������ Queue�� �ִ´�.
					for(int k=0;k<4;k++) {
						
						int nx = i+dx[k];
						int ny = j+dy[k];
						while(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]!='*') {
							if(map[nx][ny]=='#') {
								System.out.println(0);
								return;
								}
							if(map[nx][ny]=='!') {
								que.offer(new int[] {nx,ny});
				//				System.out.println(nx+","+ny);
							}
							dp[nx][ny]=0;
							nx+=dx[k];
							ny+=dy[k];
						}
					}
					
					break outer;
				}
			
		
		for(int[] e:dp)
			System.out.println(Arrays.toString(e));
	
		int cnt=0;
		
		while(!que.isEmpty()) {
			
			//1. ť���� �� ���� �ű� �ſ��� ��ġ�ϸ� �� �� �ִ� ���� ǥ���Ұ���
			// ���Ʒ� �Ǵ� �¿�� �� ���������� ���鼭 dp ������Ʈ(�ڱ�+1)
			// ���ٰ� �ſ� ������ ť�� �ִ´�.
			// ���� ���ٰ� ���� �ſ� �� dp�� -1�� �ƴϸ� ���Ѵ�(���⵵ ����ؼ�)
			//���ٰ� #������ ��. ���
			
			int SIZE = que.size();
			cnt++;
			while(SIZE-->0) {
				
				int[] mir = que.poll();
				int x = mir[0]; int y = mir[1];
				
				for(int k=0;k<4;k++) {
					
					int nx = x+dx[k];
					int ny = y+dy[k];
					
					while(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]!='*') {
						
						if(nx==ex && ny==ey) {
							System.out.println(cnt);
							return;
							}
						
						if(dp[nx][ny]!=-1) { 
							nx +=dx[k];
							ny +=dy[k];
							continue;
						}
						
						if(map[nx][ny]=='!')
							que.offer(new int[] {nx,ny});
						dp[nx][ny]=cnt;
						nx +=dx[k];
						ny +=dy[k];
					}
				}
			}
			System.out.println("----------------------");
			
			for(int[] e:dp)
				System.out.println(Arrays.toString(e));
			
		}
		
	}

}
