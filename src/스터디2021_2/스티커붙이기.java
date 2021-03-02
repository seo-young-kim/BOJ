package ���͵�2021_2;
import java.util.*;
import java.io.*;
public class ��ƼĿ���̱� {

	static boolean[][] map;
	static int[][][] stick;
	static int N,M,K;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		stick = new int[K][][];
		for(int i=0;i<K;i++) {
			
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			stick[i]=new int[R][C];
			for(int r=0;r<R;r++) {
				st = new StringTokenizer(bf.readLine());
				for(int c=0;c<C;c++)
					stick[i][r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<K;k++)
			tryAttach(k);
		
		int cnt=0;
		for(int r=0;r<N;r++)
			for(int c=0;c<M;c++)
				if(map[r][c])
					cnt++;
		
		System.out.println(cnt);
	}
	
	public static void tryAttach(int k) {
		//�ִ� 4�� �õ���
		//�ð�������� 90�� ȸ��
		for(int d=0;d<4;d++) {
			//q�ٿ�����.
			if(isAttach(k))
				break;
			rotate(k);
		}
	}
	
	//stick[k] ���� ������ �ٿ�����.
	public static boolean isAttach(int k) {
		
		int R = stick[k].length;
		int C = stick[k][0].length;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(i+R<=N && j+C<=M)
					//����
					if(check(i,j,k))
						return true;
							
		
		return false;
	}
	
	public static boolean check(int x,int y,int k) {
		int R = stick[k].length;
		int C = stick[k][0].length;
		
		//���ϼ� �ִ��� üũ
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++)
				if(stick[k][r][c]==1 && map[r+x][c+y])
					return false;
			
		//����
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++)
				if(stick[k][r][c]==1)
					map[r+x][c+y]=true;
		
		return true;
	}
	
	public static void rotate(int k) {
		
		//k��° ��ƼĿ�� �ð�������� 1�� ȸ��
		int R = stick[k].length;
		int C = stick[k][0].length;
		int[][] temp = new int[C][R];
		
		for(int r=0;r<R;r++)
			for(int c=0;c<C;c++)
				temp[c][R-1-r]=stick[k][r][c];
		
		stick[k]=temp;
		
	}

}
