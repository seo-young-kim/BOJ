package 스터디2021;
import java.io.*;
import java.util.*;

class Teacher{
	int x,y;
	Teacher(int x,int y){ this.x=x; this.y=y;}
}
public class 감시피하기 {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[][] tmap = new int[N][N];
		int[][] smap = new int[N][N];
		char[][] map = new char[N][N];
		
		int tlen=0; int slen=0;
		//tmal, smap, map 입력받기
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
		
		//teacher 객체 배열 
		Teacher[] teacher = new Teacher[tlen+1];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(tmap[i][j]!=0)
					teacher[tmap[i][j]]=new Teacher(i,j);
		
		List[] list = new List[tlen+1];
		
		for(int i=1;i<=tlen;i++)
			list[i]=new LinkedList<>();
		
		//1이면 예비 장애물 체크된거, 2면 돌
		int[][] road = new int[N][N];
		
		//count
		int count=0; // list추가된 원소 개수
		int wall=0; // 세원 장애물 개수
		
		int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
		
		//teacher 돌기
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
