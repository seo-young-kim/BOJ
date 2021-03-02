
import java.io.*;
import java.util.*;

public class pro16639 {

	
	static char[] equ;
	static int[][] min;
	static int[][] max;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		equ = new char[N];
		String str = bf.readLine();
		for(int i=0;i<N;i++)
			equ[i]=str.charAt(i);
		
		int M = N/2+1;
		min = new int[M][M];
		max = new int[M][M];
		
		//길이 하나
		for(int i=0;i<M;i++) {
			min[i][i]=equ[i*2]-'0';
			max[i][i]=equ[i*2]-'0';
		}
		//길이 둘
		for(int i=0;i<M-1;i++) {
			min[i][i+1]=operator(min[i][i],min[i+1][i+1],i*2+1);
			max[i][i+1]=min[i][i+1];
		}
		
		//길이 3~M
		for(int l=3;l<=M;l++) {
			for(int i=0;i<=M-l;i++) {
			
			//min[i][j]
			int j = i+l-1;
			int m = 987654321;
			for(int k=i;k<j;k++) {
				int op = k*2+1;
				m = Math.min(m, min(i,k,j,equ[op]));
			}
			min[i][j]=m;
			
			//max[i][i+l-1]
			m = -987654321;
			for(int k=i;k<j;k++) {
				int op = k*2+1;
				m = Math.max(m, max(i,k,j,equ[op]));
			}
			max[i][j]=m;
			}
		}
		
		System.out.println(max[0][M-1]);
	}

	public static int max(int n1,int k,int n2,char op) {
		
		
		if(op=='+') return max[n1][k]+max[k+1][n2];
		if(op=='-') return max[n1][k]-min[k+1][n2];
		else {
			
			int m = -987654321;
			m = Math.max(m, min[n1][k]*min[k+1][n2]);
			m = Math.max(m, min[n1][k]*max[k+1][n2]);
			m = Math.max(m, max[n1][k]*min[k+1][n2]);
			m = Math.max(m, max[n1][k]*max[k+1][n2]);
			
			return m;
		}
		
	} 
	public static int min(int n1,int k,int n2,char op) {
		
		
		if(op=='+') return min[n1][k]+min[k+1][n2];
		if(op=='-') return min[n1][k]-max[k+1][n2];
		else {
			
			int m = 987654321;
			m = Math.min(m, min[n1][k]*min[k+1][n2]);
			m = Math.min(m, min[n1][k]*max[k+1][n2]);
			m = Math.min(m, max[n1][k]*min[k+1][n2]);
			m = Math.min(m, max[n1][k]*max[k+1][n2]);
			
			return m;
		}
		
	} 
	
	//
	public static int operator(int n1,int n2,int index) {
		
		char op = equ[index];
		switch(op) {
		case '+': return n1+n2;
		case '-': return n1-n2;
		case '*': return n1*n2;
		}
		return 0;
		
	}
}
