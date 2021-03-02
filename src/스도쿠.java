import java.io.*;

public class ������ {

	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		int cnt=0;
		for(int i=0;i<9;i++) {
			String str = bf.readLine();
			for(int j=0;j<9;j++) {
				map[i][j]=str.charAt(j)-'0';
				if(map[i][j]==0)
					cnt++;
			}
		}
		
		bt(0,0,cnt);
	
	}
	
	
	public static void bt(int x,int y,int count) {
		
		if(count==0) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			System.exit(0);
		}
			
		
		//x,y ���� Ž��, (�������� �� ä����) 0�ΰ� ������
outer:	for(int i=x;i<9;i++) {
	
			int k=0;
			if(i==x) k=y;
			for(int j=k;j<9;j++) {
				
				if(map[i][j]!=0) continue;
				
				for(int n=1;n<10;n++) {
					
					if(check(i,j,n)) {
						map[i][j]=n;
						bt(i,j,count-1);
						map[i][j]=0;
					}
				}
				
				break outer;
			
			}
			
		}	
	}
	
	public static boolean check(int x,int y,int n) {
		
		//��,�� üũ
		for(int i=0;i<9;i++) {
			if(map[x][i]==n)
				return false;
			if(map[i][y]==n)
				return false;
		}
		
		int r = (x/3)*3;
		int c = (y/3)*3;
		
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++)
				if(map[i][j]==n)
					return false;
		}
		
		return true;
	}

}
