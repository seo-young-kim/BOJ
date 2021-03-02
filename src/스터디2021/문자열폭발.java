package 스터디2021;
import java.io.*;
import java.util.*;


public class 문자열폭발 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] string = bf.readLine().toCharArray();
		char[] bomb = bf.readLine().toCharArray();
		
		int[][] stack = new int[string.length][];
		//지금 채워야 하는 자리
		int idx=0;
		
		for(int i=0;i<string.length;i++) {
			//스택에 아무것도 없음
			if(idx==0)
				if(bomb[0]==string[i]) {
					if(bomb.length>1) {
						stack[idx]=new int[2];
						stack[idx][0]= i ;
						stack[idx][1]=0;
					}	
				}else {
					stack[idx]=new int[1];
					stack[idx][0]=i;
				}
			else {
			
				int[] prev = stack[idx-1];
				List<Integer> list = new LinkedList<>();
				
				//이전꺼에서 이어질 가능성있음, -> bomb length>1
				for(int k=1;k<prev.length;k++)
					if(bomb[prev[k]+1]==string[i])
						list.add(prev[k]+1);
					
				//첫 문자로 가능?
				if(bomb[0]==string[i])
					list.add(0);
				
				//위에 두가지 다 안되면, 폭발 안하는 문자열
				//얘포함해서 앞에꺼 까지 다 폭발 안함
				stack[idx] = new int[list.size()+1];

				Iterator itr = list.iterator();
				boolean flag = false;
				int index=0;
				stack[idx][0]=i;
				
				//옮겨 담으면서 터지는지 확인
				while(itr.hasNext()) {
					int next= (Integer)itr.next();
					if(next==bomb.length-1)
						flag=true;
					stack[idx][++index]=next;
				}
				
				
				if(flag) {
					idx-=bomb.length;
				}
				}
			idx++;
		}
		
		
		if(idx==0)
			System.out.println("FRULA");
		else {
			
		bw.flush();
		bw.close();
		}
	}
		
	
}