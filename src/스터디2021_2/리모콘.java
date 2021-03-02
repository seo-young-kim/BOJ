package ���͵�2021_2;
import java.util.*;
import java.io.*;

public class ������ {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String N = bf.readLine();

		int NUMBER = Integer.parseInt(N);
		// �Ұ����� ���� check
		boolean[] p = new boolean[10];
		Arrays.fill(p, true);
		int K = Integer.parseInt(bf.readLine());
		
		if(K>0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=0;i<K;i++)
			p[Integer.parseInt(st.nextToken())]=false;
		}
		
		//���� �ȴ����� �׳� + - �� ������ Ƚ��
		int answer = Math.abs(NUMBER-100);
		
		//���� ���� �� �ִ� ���ڰ� ������ �̴�� ���
		if(K==10) {
			System.out.println(answer);
			return;
		}
		
		if(K==0) {
			System.out.println(Math.min(answer, N.length()));
			return;
		}
		
		for(int i=0;i<1000000;i++) {
			
			boolean isOK=true;
			String v = i+"";
			for(int j=0;j<v.length();j++)
				if(!p[v.charAt(j)-'0']) {
					isOK=false; break;
				}
			
			if(isOK)
				answer = Math.min(answer, v.length()+Math.abs(NUMBER-Integer.parseInt(v)));
		}
		
		System.out.println(answer);
		
	}

}
