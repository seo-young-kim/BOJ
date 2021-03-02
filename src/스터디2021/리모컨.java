package 스터디2021;
import java.util.*;
import java.io.*;

public class 리모컨 {

	//가고 싶은 숫자 
	static int NUMBER;
	static String N;
	//누를 수 있는 수
	static boolean[] p;
	//최소 횟수
	static int answer;
	//숫자 개수
	static int NumOfDigits;
	static int minDigit=9;
	static int maxDigit=0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = bf.readLine();
		NUMBER = Integer.parseInt(N);
		// 불가능한 숫자 check
		p = new boolean[10];
		Arrays.fill(p, true);
		int K = Integer.parseInt(bf.readLine());
		if(K>0) {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<K;i++)
			p[Integer.parseInt(st.nextToken())]=false;
		}
		//숫자 안누르고 그냥 + - 만 했을때 횟수
		answer = Math.abs(NUMBER-100);
		//만일 누를 수 있는 숫자가 없으면 이대로 출력
		if(K==10) {
			System.out.println(answer);
			return;
		}
		
		
		//숫자를 character Array
		NumOfDigits = N.length();
		//가능한 가장 큰 수와 작은수
		for(int i=0;i<10;i++)
			if(p[i]) {
				minDigit = Math.min(minDigit, i);
				maxDigit = Math.max(maxDigit, i);
			}
		
		// 6 7 8
		// 5 4 5 7
		// 4 9 9 9
		//1. N보다 작은 곳에서 오는 경우
		// 
		int[] temp = new int[NumOfDigits];
		smaller(0,temp);
		//작은 수가 없음
		if(temp[0]==-1) {
			if(NumOfDigits>1) {
				temp[0]=0;
				answer = Math.min(answer,count(temp));
			}
		}
		else
			answer = Math.min(answer,count(temp));

		//2. N보다 큰 수에서 올때
		// 9 0 0 0
		// 10 0 0 0
		temp = new int[NumOfDigits];
		bigger(0,temp);
		if(temp[0]==-1) {
			//앞 두자리를 채움
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
		//3. 첫번째 숫자를 누를 수 있을때
		if(p[N.charAt(0)-'0']) {
			temp = new int[NumOfDigits];
			temp[0]=N.charAt(0)-'0';
			bt(temp,1);
		}
		
		System.out.println(answer);
		
	}
	
	//arr[d-1]까지는 채워진 상태
	public static void bt(int[] arr,int d) {
		
	//	System.out.println(d);
		if(d==NumOfDigits) {
			answer = Math.min(answer, NumOfDigits);
			return;
		}
		
		// 5 3 9 9
		//1. arr[d]에 N.at(d)보다 작은 수 넣을때
		smaller(d,arr);
		if(arr[d]!=-1)
			answer = Math.min(answer,count(arr));
		
		// 5 5 0 0
		//2.arr[d]에 N.at(d)보다 큰 수 넣을때
		bigger(d,arr);
		if(arr[d]!=-1)
			answer = Math.min(answer,count(arr));
		//3.arr[d]에 N.at(d)와 같은 수
		// 5 4 - -
		if(p[N.charAt(d)-'0']) {
			arr[d]=N.charAt(d)-'0';
			
			bt(arr,d+1);
		}
		
	}
	
	//arr있는 수에서 목표 숫자까지 가는데 눌러야하는 숫자 개수 리턴
	public static int count(int[] arr) {
		int number = arrayToInt(arr);
		int cnt = String.valueOf(number).length(); //이만큼 숫자 눌렀음
		cnt+=Math.abs(number-NUMBER); //+-로 가야함
		//System.out.println(Arrays.toString(arr));
		return cnt;
		
	}
	
	//d번째 자리 수를 조정할 차례이다. 
	public static void smaller(int d,int[] arr) {
		
		//첫번째수 
		arr[d] = minNum(N.charAt(d)-'0');
		
		for(int i=d+1;i<NumOfDigits;i++)
			arr[i]=maxDigit;
		
	}
	
	public static void bigger(int d, int[] arr) {
		
		arr[d] = maxNum(N.charAt(d)-'0');
		
		for(int i=d+1;i<NumOfDigits;i++)
			arr[i]=minDigit;
	}
	
	//n보다 작은 애 중 가장 큰 애
	public static int minNum(int n) {
		for(int i=n-1;i>=0;i--)
			if(p[i]) return i;
		return -1;
	}
	//n보다 큰 애 중 가장 작은애
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
