package ���͵�2021;
import java.io.*;
import java.util.*;


public class ���ڿ����� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] string = bf.readLine().toCharArray();
		char[] bomb = bf.readLine().toCharArray();
		
		int[][] stack = new int[string.length][];
		//���� ä���� �ϴ� �ڸ�
		int idx=0;
		
		for(int i=0;i<string.length;i++) {
			//���ÿ� �ƹ��͵� ����
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
				
				//���������� �̾��� ���ɼ�����, -> bomb length>1
				for(int k=1;k<prev.length;k++)
					if(bomb[prev[k]+1]==string[i])
						list.add(prev[k]+1);
					
				//ù ���ڷ� ����?
				if(bomb[0]==string[i])
					list.add(0);
				
				//���� �ΰ��� �� �ȵǸ�, ���� ���ϴ� ���ڿ�
				//�������ؼ� �տ��� ���� �� ���� ����
				stack[idx] = new int[list.size()+1];

				Iterator itr = list.iterator();
				boolean flag = false;
				int index=0;
				stack[idx][0]=i;
				
				//�Ű� �����鼭 �������� Ȯ��
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