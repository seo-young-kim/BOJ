import java.util.*;
import java.io.*;

public class 한줄로서기 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		//입력받는 배열
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		//
		LinkedList<Integer> list = new LinkedList<>();
		
		//      1 2 3 4
		//arr = 2 1 1 0
		
		// list -> 4 2 1 3
		
		for(int k=N;k>0;k--) {
			int count = arr[k];
			int index=0;
	
			for(int i=0;i<list.size();i++) {
				if(list.get(i)>k)
					count--;
				if(count==0) {
					index = i+1;
					break;
				}
			}
			list.add(index, k);
		}
		
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
		
	}

}
