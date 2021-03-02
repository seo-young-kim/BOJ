package 스터디2021;
import java.io.*;

public class 막대기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cnt=0;
		
		for(int i=0;(1<<i)<=N;i++)
			if(((1<<i)&N)!=0)
				cnt++;
		System.out.println(cnt);
	}

}
