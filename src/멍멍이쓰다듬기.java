
import java.io.*;
import java.util.*;

public class ∏€∏€¿Ãæ≤¥ŸµÎ±‚ {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int monkey = Integer.parseInt(st.nextToken());
		int dog = Integer.parseInt(st.nextToken());
		
		if(monkey+1==dog) {
			System.out.println(1);
			return;
		}
						// height , increase
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {monkey+1,1});
		
		int day=1;
		int[] add= {-1,0,1};
		while(true) {
			
			int size = que.size();
			while(size-->0) {
				
				int[] cur = que.poll();
				int height = cur[0];
				int inc = cur[1];
				if(height == dog && inc==1) {
					System.out.print(day);
					return;
				}
				
				for(int k=0;k<3;k++) {
					// increase + add[k] ∏∏≈≠ ¥√∏± ºˆ ¿÷¿Ω
					if(inc+add[k]<0) continue;
					que.offer(new int[] {height+inc+add[k],inc+add[k]});
				}
			}
			
			day++;
			
		}
		
	
	}

}
