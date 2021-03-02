package 스터디2021_2;
import java.io.*;

public class 회문 {

	static int s,e;
	static char[] str;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Tc = Integer.parseInt(bf.readLine());
		
		while(Tc-->0) {
			str = bf.readLine().toCharArray();
			s=0; e=str.length-1;
			ispallen();
			
			if(s>=e) {
				bw.write(0+"\n");
				continue;
			}
			
			int orins=s;
			int orine=e;
			
			s++;
			ispallen();
			if(s>=e) {
				bw.write(1+"\n");
				continue;
			}
			
			s=orins;
			e = orine;
			e--;
			ispallen();
			if(s>=e) {
				bw.write(1+"\n");
				continue;
			}
			
			bw.write(2+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	public static void ispallen() {
		
		while(str[s]==str[e] && s<e) {
			s++; e--;
		}
		
	}
}