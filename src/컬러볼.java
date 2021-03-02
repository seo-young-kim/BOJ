import java.io.*;
import java.util.*;

class Ball implements Comparable<Ball>{
	int number,color,size;
	Ball(int num,int c,int s){
		number=num;	color=c; size=s;
	}
	public int compareTo(Ball o) {
		return this.size-o.size;
	}	
}

public class 컬러볼 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Ball[] ball = new Ball[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ball[i]=new Ball(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		//크기대로 정렬
		Arrays.sort(ball);
		
		int[] color = new int[N+1];
		int[] answer = new int[N];
		
		int Ss = 0;
		
		for(int i = 0,j=0; i<N; i++){
			
			for(; ball[j].size<ball[i].size; j++){ 
		
				Ss += ball[j].size; 
				color[ball[j].color] += ball[j].size; 
			}
			
			answer[ball[i].number] += Ss - color[ball[i].color]; 
		} 
		
		
		for(int i=0;i<N;i++)
			bw.write(answer[i]+"\n");
	
		bw.flush();
		bw.close();
	}
}