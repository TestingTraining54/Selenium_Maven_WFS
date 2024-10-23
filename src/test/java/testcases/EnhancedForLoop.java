package testcases;

import java.util.ArrayList;
import java.util.List;

public class EnhancedForLoop {

	public static void main(String[] args) {
		List<Character> al1 = new ArrayList<Character>();
		al1.add('a');
		al1.add('b');
		al1.add('c');
		
		/*
		 * for(int i=0;i<al.size();i++) { System.out.println(al.get(i)); }
		 */
		
		//Enhanced For loop
		for(Character x:al1) {
			System.out.println(x);//abc -- xyz
		}
	}

}
