package ���͵�2021;
import java.io.*;
import java.util.*;

class Teacher{
	int x,y;
	Teacher(int x,int y){ this.x=x; this.y=y;}
}
public class �������ϱ� {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[][] tmap = new int[N][N];
		int[][] smap = new int[N][N];
		char[][] map = new char[N][N];
		
		int tlen=0; int slen=0;
		//tmal, smap, map �Է¹ޱ�
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				char next = st.nextToken().charAt(0);
				map[i][j]=next;
				if(next=='S') {
					slen++;
					smap[i][j] = slen;
				}
				if(next=='T') {
					tlen++;
					tmap[i][j]=tlen;
				}
			}
		}
		
		//teacher ��ü �迭 
		Teacher[] teacher = new Teacher[tlen+1];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(tmap[i][j]!=0)
					teacher[tmap[i][j]]=new Teacher(i,j);
		
		List[] list = new List[tlen+1];
		
		for(int i=1;i<=tlen;i++)
			list[i]=new LinkedList<>();
		
		//1�̸� ���� ��ֹ� üũ�Ȱ�, 2�� ��
		int[][] road = new int[N][N];
		
		//count
		int count=0; // list�߰��� ���� ����
		int wall=0; // ���� ��ֹ� ����
		
		int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
		
		//teacher ����
		for(int t=1;t<=tlen;t++) {
			
			for(int k=0;k<4;k++) {
				
				
				
			}
			
			
		}
		
		if(count+wall<=3)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
