package 스터디2021_2;
import java.util.*;
import java.io.*;

public class 공항 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(bf.readLine());
		int P = Integer.parseInt(bf.readLine());
		boolean[] gate = new boolean[G+1];
		for(int i=0;i<=G;i++)
			gate[i]=true;
		
		int cnt=0;
		for(int i=0;i<P;i++) {
			int g=Integer.parseInt(bf.readLine());
			
			while(!gate[g])
				g--;
			
			if(g==0)
				break;
			
			gate[g]=false;
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
