package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28702 {
	
	static String a,b,c;
	static int num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		if(!(a.contains("z"))) {
			num = Integer.parseInt(a)+3;
		}
		
		if(!(b.contains("z"))) {
			num = Integer.parseInt(b)+2;
		}
		
		if(!(c.contains("z"))) {
			num = Integer.parseInt(c)+1;
		}
		
		if(num%3 == 0 && num%5 == 0) {
			System.out.println("FizzBuzz");
		}else if(num%3 == 0) {
			System.out.println("Fizz");
		}else if(num%5 == 0) {
			System.out.println("Buzz");
		}else {
			System.out.println(num);
		}
	}
}
