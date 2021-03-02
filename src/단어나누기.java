
import java.io.*;

public class 단어나누기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] words = bf.readLine().toCharArray();
		
		int N = words.length;
		
		//first
		int index1=0;
		for(int i=0;i<N-2;i++)
			
			if(words[index1]>words[i])
				index1=i;
		
		//second
		int index2=index1+1;
		for(int i=index1+2;i<N-1;i++)
			if(words[index2]>words[i])
				index2=i;
		
		for(int i=index1;i>=0;i--)
			System.out.print(words[i]);
		for(int i=index2;i>index1;i--)
			System.out.print(words[i]);
		for(int i=N-1;i>index2;i--)
			System.out.print(words[i]);
		
		
	}

}
