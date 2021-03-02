package 스터디2021;
import java.util.*;
import java.io.*;

public class 랜선자르기 {

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
		
		//case1> 가장 긴 랜선이 1이라면 자르고 자시고 할 것도 없음(1==maxlen)
		if(max_lan==1) {System.out.println(1); return; }
		
		// 가능한 랜선 길이의 범위 l ~ r
		int l = 1; int r = max_lan;
		
		/*1길이로 자르면 얻을 수 있는 랜선 개수 (구할 필요 없어서 삭제)
		int l_sum =0;
		for(int i=0;i<K;i++)
			l_sum+=lan[i];*/ 
		
		//maxlen으로 자르면 얻을 수 있는 랜선 개수
		int r_sum = 0;
		for(int i=0;i<K;i++) {
			if(max_lan==lan[i])
				r_sum++;
		}
		
		//case2> 만일 r_sum만큼만 필요하면 가장 큰 랜선 그냥 주면 됨
			if(N==r_sum) { System.out.println(max_lan); return; }
		
		//그게 아니라면, 잘라야함(답은 1보다 크거나 같고  max_lan보다 작음)
		
		while(l<r){
			
			//long아닌데 왜 돼지..? l+r이 int범위가 아니지 않나? 중간과정이라 가능한가
			int mid = (l+r)/2;	
	
			//l<r이고 l=mid면 둘이 하나 차이남
			if(l==mid) break;
			
			//mid로 자르면 얻을 수 있는 랜선의 총 개수
			long sum = numOfLan(mid);
		
			//Binary Search 범위 조정
			if(sum>=N)
				l=mid;
			else r=mid;
		
		}
		
		System.out.println(l);
		
		
	}
	
	
	//len길이로 자르면 얻을 수 있는 총 랜선 개수
	public static long numOfLan(int len) {
		
		long sum = 0l;
		
		//lan[i]를 mid길이로 자르면 얻을수 있는 랜선의 개수 구해서 더함
		long multi=1l;
		//multi int로 하면 틀림
					
		for(int i=0;i<lan.length;i++) {
			
			while(len*multi<=lan[i])
				multi++;
			//multi-1 만큼은 가능함
			multi--;
			sum+=multi;
		}
		
		return sum;
	}
	
	

}
