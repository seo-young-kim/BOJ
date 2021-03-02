import java.util.*;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baabaa";
		Deque<Character> deq = new LinkedList<>();
		
		for(int i=0;i<s.length();i++) {
			
			if(deq.isEmpty()) {
				deq.offerFirst(s.charAt(i));
				continue;
			}
			char top = deq.peekFirst();
			if(top == s.charAt(i))
				deq.pollFirst();
			else
				deq.offerFirst(s.charAt(i));
		}
		
		
	}

}
