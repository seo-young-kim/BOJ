package 스터디2021;
import java.util.*;
import java.io.*;


class Node{
	
	boolean end = false;
	
	Node[] node;
	Node(){
		node = new Node[10];
	}
	
	void end() {end=true;}
	
	boolean isend() {
		return end;
	}
	
}

public class 전화번호목록 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//testcase
		for(int t=0;t<Tc;t++) {
			
			int N = Integer.parseInt(bf.readLine());
			Node root = new Node();
			
			Node arrow;
			
			boolean flag = true;
			//n개의 번호
			for(int n=0;n<N;n++) {
	
				String number = bf.readLine();
				if(!flag) continue;
				arrow = root;
				int len = number.length();
				
				for(int k=0;k<len;k++) {
					int cur = number.charAt(k)-'0';
					
					if(k==len-1 && arrow.node[cur]!=null) {
						flag = false;
						break;
					}
					//없으면 생성
					if(arrow.node[cur]==null)
						arrow.node[cur]=new Node();
					
					//따라 내려감
					arrow=arrow.node[cur];
					
					//end가 true면 prefix
					if(arrow.isend()) {
						flag = false;
						break;
					}
					//마지막이면 end표시해줌
					
					if(k==len-1)
						arrow.end();
				}
				
			}
			
			if(flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");
			bw.flush();
		}
		
		bw.close();
	}

}
