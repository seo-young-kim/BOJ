package 스터디2021;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class 잠수함식별2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		
		Pattern pattern = Pattern.compile( "^(100+1+|01)+");
		
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
		
		
	}

}
