import java.util.*;
import java.io.*;

public class 연결요소의개수 {

	static List[] list;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//adjacent List
		list = new List[N];
		
		for(int i=0;i<N;i++) {
			list[i]=new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a-1].add(b-1);
			list[b-1].add(a-1);
		}

		//DFS
		int cnt = 0;
		check = new boolean[N];
		for(int i=0;i<N;i++)
			if(!check[i]) {
				dfs(i);
				cnt++;
			}
		
		System.out.println(cnt);
		
	}
	
	static boolean[] check;
	
	public static void dfs(int s) {
		
		check[s]=true;
		
		Iterator itr = list[s].iterator();
		
		while(itr.hasNext()) {
			
			int next = (int)itr.next();
			if(!check[next])
				dfs(next);
		}
		
	}

}
