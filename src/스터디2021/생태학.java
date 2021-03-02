package 스터디2021;
import java.util.*;
import java.io.*;

public class 생태학 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		HashMap<String,Integer> map = new HashMap<>();
		
		while(true){
			
			String input = bf.readLine();
			if(input == null || input.isEmpty())
				break;
			
			if(map.containsKey(input)) {
				int num = map.get(input);
				map.put(input, num+1);
			}else {
				map.put(input, 1);
			}
			total++;
		}
		
		Object[] key = map.keySet().toArray();
		Arrays.sort(key);
		for(int i=0;i<key.length;i++) {
			float percentage = (float)(map.get(key[i])*100)/(float)total;
			System.out.println(key[i]+" "+String.format("%.4f",percentage));
		}
		
	}

}
