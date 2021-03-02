package ���͵�2021;
import java.util.*;
import java.io.*;

public class ������ {

	//���� ���� ���� 
	static int NUMBER;
	static String N;
	//���� �� �ִ� ��
	static boolean[] p;
	//�ּ� Ƚ��
	static int answer;
	//���� ����
	static int NumOfDigits;
	static int minDigit=9;
	static int maxDigit=0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = bf.readLine();
		NUMBER = Integer.parseInt(N);
		// �Ұ����� ���� check
		p = new boolean[10];
		Arrays.fill(p, true);
		int K = Integer.parseInt(bf.readLine());
		if(K>0) {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<K;i++)
			p[Integer.parseInt(st.nextToken())]=false;
		}
		//���� �ȴ����� �׳� + - �� ������ Ƚ��
		answer = Math.abs(NUMBER-100);
		//���� ���� �� �ִ� ���ڰ� ������ �̴�� ���
		if(K==10) {
			System.out.println(answer);
			return;
		}
		
		
		//���ڸ� character Array
		NumOfDigits = N.length();
		//������ ���� ū ���� ������
		for(int i=0;i<10;i++)
			if(p[i]) {
				minDigit = Math.min(minDigit, i);
				maxDigit = Math.max(maxDigit, i);
			}
		
		// 6 7 8
		// 5 4 5 7
		// 4 9 9 9
		//1. N���� ���� ������ ���� ���
		// 
		int[] temp = new int[NumOfDigits];
		smaller(0,temp);
		//���� ���� ����
		if(temp[0]==-1) {
			if(NumOfDigits>1) {
				temp[0]=0;
				answer = Math.min(answer,count(temp));
			}
		}
		else
			answer = Math.min(answer,count(temp));

		//2. N���� ū ������ �ö�
		// 9 0 0 0
		// 10 0 0 0
		temp = new int[NumOfDigits];
		bigger(0,temp);
		if(temp[0]==-1) {
			//�� ���ڸ��� ä��
			temp = new int[NumOfDigits+1];
			Arrays.fill(temp, minDigit);
			for(int i=1;i<10;i++)
				if(p[i]) {temp[0]=i;break;}
			
			for(int i=0;i<10;i++)
				if(p[i]) {temp[1]=i;break;}
			answer=Math.min(answer,count(temp));
		}else
			answer=Math.min(answer, count(temp));
		
		// 5 - - - 
		//3. ù��° ���ڸ� ���� �� ������
		if(p[N.charAt(0)-'0']) {
			temp = new int[NumOfDigits];
			temp[0]=N.charAt(0)-'0';
			bt(temp,1);
		}
		
		System.out.println(answer);
		
	}
	
	//arr[d-1]������ ä���� ����
	public static void bt(int[] arr,int d) {
		
	//	System.out.println(d);
		if(d==NumOfDigits) {
			answer = Math.min(answer, NumOfDigits);
			return;
		}
		
		// 5 3 9 9
		//1. arr[d]�� N.at(d)���� ���� �� ������
		smaller(d,arr);
		if(arr[d]!=-1)
			answer = Math.min(answer,count(arr));
		
		// 5 5 0 0
		//2.arr[d]�� N.at(d)���� ū �� ������
		bigger(d,arr);
		if(arr[d]!=-1)
			answer = Math.min(answer,count(arr));
		//3.arr[d]�� N.at(d)�� ���� ��
		// 5 4 - -
		if(p[N.charAt(d)-'0']) {
			arr[d]=N.charAt(d)-'0';
			
			bt(arr,d+1);
		}
		
	}
	
	//arr�ִ� ������ ��ǥ ���ڱ��� ���µ� �������ϴ� ���� ���� ����
	public static int count(int[] arr) {
		int number = arrayToInt(arr);
		int cnt = String.valueOf(number).length(); //�̸�ŭ ���� ������
		cnt+=Math.abs(number-NUMBER); //+-�� ������
		//System.out.println(Arrays.toString(arr));
		return cnt;
		
	}
	
	//d��° �ڸ� ���� ������ �����̴�. 
	public static void smaller(int d,int[] arr) {
		
		//ù��°�� 
		arr[d] = minNum(N.charAt(d)-'0');
		
		for(int i=d+1;i<NumOfDigits;i++)
			arr[i]=maxDigit;
		
	}
	
	public static void bigger(int d, int[] arr) {
		
		arr[d] = maxNum(N.charAt(d)-'0');
		
		for(int i=d+1;i<NumOfDigits;i++)
			arr[i]=minDigit;
	}
	
	//n���� ���� �� �� ���� ū ��
	public static int minNum(int n) {
		for(int i=n-1;i>=0;i--)
			if(p[i]) return i;
		return -1;
	}
	//n���� ū �� �� ���� ������
	public static int maxNum(int n) {
		for(int i=n+1;i<10;i++)
			if(p[i])  return i;
		return -1;
		}
	
	public static int arrayToInt(int[] numbers) {
		
		int number=0;
		for(int i=0;i<numbers.length;i++)
			number = number*10 + (numbers[i]);
		return number;
	}

}
