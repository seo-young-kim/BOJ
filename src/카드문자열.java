import java.io.*;
import java.util.*;

public class 카드문자열 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Tc = Integer.parseInt(bf.readLine());
		
		while(Tc-->0) {
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			
			for(int i=1;i<N;i++) {
				char next = st.nextToken().charAt(0);
				if(str.charAt(0)>=next)
					str =next+str;
				else
					str +=next;
			}	
			bw.write(str+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}