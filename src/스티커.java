import java.io.*;

public class 스티커 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int Tc = Integer.parseInt(bf.readLine());
		
		while(Tc-->0) {
			
			//입력
			int N = Integer.parseInt(bf.readLine());
			int[][] stick = new int[2][N];
			
			for(int i=0;i<2;i++) {
				String[] stickSTR = bf.readLine().split(" ");
				for(int j=0;j<N;j++)
					stick[i][j]=Integer.parseInt(stickSTR[j]);
			}
			
			//dp
			for(int i=1;i<N;i++) {
				stick[0][i]=Math.max(stick[0][i]+stick[1][i-1], stick[0][i-1]);
				stick[1][i]=Math.max(stick[1][i]+stick[0][i-1], stick[1][i-1]);
			}
			
			System.out.println(Math.max(stick[0][N-1], stick[1][N-1]));
		}
		
	}

}
