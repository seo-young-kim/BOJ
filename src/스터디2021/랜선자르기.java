package ���͵�2021;
import java.util.*;
import java.io.*;

public class �����ڸ��� {

	static int[] lan;
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		lan = new int[K];
		
		for(int i=0;i<K;i++)
			lan[i]=Integer.parseInt(bf.readLine());
		
		Arrays.sort(lan);
		int max_lan = lan[K-1];
		
		//case1> ���� �� ������ 1�̶�� �ڸ��� �ڽð� �� �͵� ����(1==maxlen)
		if(max_lan==1) {System.out.println(1); return; }
		
		// ������ ���� ������ ���� l ~ r
		int l = 1; int r = max_lan;
		
		/*1���̷� �ڸ��� ���� �� �ִ� ���� ���� (���� �ʿ� ��� ����)
		int l_sum =0;
		for(int i=0;i<K;i++)
			l_sum+=lan[i];*/ 
		
		//maxlen���� �ڸ��� ���� �� �ִ� ���� ����
		int r_sum = 0;
		for(int i=0;i<K;i++) {
			if(max_lan==lan[i])
				r_sum++;
		}
		
		//case2> ���� r_sum��ŭ�� �ʿ��ϸ� ���� ū ���� �׳� �ָ� ��
			if(N==r_sum) { System.out.println(max_lan); return; }
		
		//�װ� �ƴ϶��, �߶����(���� 1���� ũ�ų� ����  max_lan���� ����)
		
		while(l<r){
			
			//long�ƴѵ� �� ����..? l+r�� int������ �ƴ��� �ʳ�? �߰������̶� �����Ѱ�
			int mid = (l+r)/2;	
	
			//l<r�̰� l=mid�� ���� �ϳ� ���̳�
			if(l==mid) break;
			
			//mid�� �ڸ��� ���� �� �ִ� ������ �� ����
			long sum = numOfLan(mid);
		
			//Binary Search ���� ����
			if(sum>=N)
				l=mid;
			else r=mid;
		
		}
		
		System.out.println(l);
		
		
	}
	
	
	//len���̷� �ڸ��� ���� �� �ִ� �� ���� ����
	public static long numOfLan(int len) {
		
		long sum = 0l;
		
		//lan[i]�� mid���̷� �ڸ��� ������ �ִ� ������ ���� ���ؼ� ����
		long multi=1l;
		//multi int�� �ϸ� Ʋ��
					
		for(int i=0;i<lan.length;i++) {
			
			while(len*multi<=lan[i])
				multi++;
			//multi-1 ��ŭ�� ������
			multi--;
			sum+=multi;
		}
		
		return sum;
	}
	
	

}
