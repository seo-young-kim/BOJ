package 스터디2021_2;
import java.io.*;
import java.util.*;

public class 통나무건너뛰기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=Tc;t++) {
			
			int N = Integer.parseInt(bf.readLine());
			int[] arr = new int[N];
			String[] st = bf.readLine().split(" ");
			for(int i=0;i<N;i++)
				arr[i]=Integer.parseInt(st[i]);
			
			//2 4 5 7 9 
			//2 5 9 7 4
			Arrays.sort(arr);
			
			int end = (N%2==0)?N-1:N;
			
			
			
			
			int min = Math.max(arr[1]-arr[0],arr[2]-arr[0]);
			
			//그냥 j=2부터 N전까지 이대로 하면 위에 아래 케이스도 나눌 필요도 없음;;;ㄴ이ㅏ런아ㅣ;ㅓ갸리
			for(int j=3;j<end;j++)
				min = Math.max(min,arr[j]-arr[j-2]);
			
			//하나 남음
			if(end<N) {
				min = Math.max(min,arr[N-1]-arr[N-2]);
				min = Math.max(min,arr[N-1]-arr[N-3]);
			}else
				min=Math.max(min,arr[N-1]-arr[N-2]);
			
			System.out.println(min);
		}
		
	}

}
