package ���͵�2021;
import java.io.*;
import java.util.*;

public class ��ٸ����� {

	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//M ���μ�
		M = Integer.parseInt(st.nextToken());
		// �Է¹޴�
		int H = Integer.parseInt(st.nextToken());
		// ���� �� �ִ� ���μ�
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
		
				
		//���� cnt�� ��ŭ ���� ���� ���� �����ϸ�, ���̻� ���ص� ��
		if(check()) {
			min = Math.min(min, cnt);
			return;
		}
		
		//�̹� cnt�������� ���� -> ���� ���غ������ڳ�?
		if(min<=cnt+1)
			return;
				
		//3���̻� ���� �� ����
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
			
			//�翷�� ����
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
