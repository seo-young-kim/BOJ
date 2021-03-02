package 스터디2021_2;
import java.util.*;
import java.io.*;

public class IQTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		//답이 여러개 인 경우
		if(N==1) {
			System.out.println("A");
			return;
		}
		
		if(N<=2) {
			if(arr[0]!=arr[1])
				System.out.println("A");
			else
				System.out.println(arr[1]);
			return;
		}
		
		int a,b;
		//
		if(arr[0]==arr[1]) {
			a=1;
			b=0;
		}else {
			a = (arr[2]-arr[1])/(arr[1]-arr[0]);
			b = arr[1]-a*arr[0];
		}
		
		for(int i=2;i<N;i++)
			if(arr[i]!=a*arr[i-1]+b) {
				System.out.println("B");
				return;
			}
		
		
		System.out.println(arr[N-1]*a+b);
		
	}

}
