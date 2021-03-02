package 스터디2021;
import java.util.*;
import java.io.*;

public class 나무조각 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 1 2 3 4 5
		int[] num = new int[5];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<5;i++)
			num[i]=Integer.parseInt(st.nextToken());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//2 1 5 3 4
		//1 term
		//1 2 3 4 5
		//2 term 
		//1 2 3 4 5
		
		boolean isKeep = true;
		//while 횟수 = 1 term
		while(isKeep) {
			
			isKeep = false;
			
			for(int i=0;i<4;i++) {
				if(num[i]>num[i+1]) {
					//바꾸기
					int temp = num[i];
					num[i]=num[i+1];
					num[i+1]=temp;
					//출력
					for(int j=0;j<5;j++)
						bw.write(num[j]+" ");
					bw.write("\n");
					isKeep = true;
				}
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

}
