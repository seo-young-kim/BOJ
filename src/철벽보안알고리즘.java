import java.io.*;
import java.util.*;

public class 철벽보안알고리즘 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(bf.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(Tc-->0) {
			
			int len = Integer.parseInt(bf.readLine());
			HashMap<String,Integer> map = new HashMap<>();
			String[] str = bf.readLine().split(" ");
			
			for(int i=0;i<len;i++)
				map.put(str[i],i);
			
			int[] temp = new int[len+1];
			String[] str2 = bf.readLine().split(" ");
			
			for(int i=0;i<len;i++) {
				int next = map.get(str2[i]);
				temp[i]=next;
			}
			
			String[] str3 = bf.readLine().split(" ");
			String[] answer = new String[len];
			for(int i=0;i<len;i++)
				answer[temp[i]]=str3[i];
			
			for(int i=0;i<len;i++)
				bw.write(answer[i]+" ");
			bw.write("\n");
			bw.flush();
			
		}
		bw.close();
		
		
	}

}
