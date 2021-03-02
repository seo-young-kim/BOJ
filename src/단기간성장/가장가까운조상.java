package 단기간성장;
import java.util.*;
import java.io.*;

public class 가장가까운조상 {

	static int[] parent;
	static int[] height;
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int Tc = Integer.parseInt(bf.readLine());
		while(Tc-->0) {
			
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st;
			parent = new int[N];
			height = new int[N];
			Arrays.fill(height, -1);
			Arrays.fill(parent, -1);
			
			for(int i=1;i<N;i++) {
				st = new StringTokenizer(bf.readLine());
				int p = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				//c의 부모는 p
				parent[c]=p;
			}
			
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			
			//1. height 구하기 
			int h1 = findDept(n1);
			int h2 = findDept(n2);
			
			//2. 타고 올라가면서 lcs 구하기 -> 출력
			if(h1>h2) {
				int temp = n1;
				n1=n2;
				n2=temp;
			}
			
			//h1<=h2
			while(height[n1]<height[n2]) {
				n2 = parent[n2];
			}
			
			//h1=h2
			while(n1!=n2) {
				n1 = parent[n1];
				n2 = parent[n2];
			}
			
			System.out.println(n1+1);
		}
		
	}
	
	public static int findDept(int node) {
		
		if(height[node]!=-1)
			return height[node];
		else {
			if(parent[node]==-1) {
				height[node]=0;
				return 0;
			}else {
			height[node] = findDept(parent[node])+1;
			return height[node];
			}
		}
	}

}
