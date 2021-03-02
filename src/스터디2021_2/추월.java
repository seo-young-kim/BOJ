package 스터디2021_2;
import java.io.*;
import java.util.*;

public class 추월 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			String car = bf.readLine();
			map.put(car,i);
		}
		
		int[] out = new int[N];
		
		for(int i=0;i<N;i++) {
			String car = bf.readLine();
			out[i] = map.get(car);
		}
		//System.out.println(Arrays.toString(out));
		//추월 여부 체크 1~N
		boolean[] check = new boolean[N+2];
		
		int next = 1;
		int fast =0;
		for(int i=0;i<N;i++) {
			
			if(out[i]==next) {
				next++;
				while(check[next]) next++;
				
			}else {
				fast++;
				check[out[i]]=true;
			}
		}
		
		System.out.println(fast);
		
	}

}
