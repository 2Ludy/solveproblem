package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2754 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("F")) {
			System.out.println(0.0);
			return;
		}
		char c1 = str.charAt(0);
		char c2 = str.charAt(1);
		
		double a;
		
		if(c1 == 'A') {
			a = 4.0;
		}else if(c1 == 'B') {
			a = 3.0;
		}else if(c1 == 'C') {
			a = 2.0;
		}else {
			a = 1.0;
		}
		
		if(c2 == '+') {
			a += 0.3;
		}else if(c2 == '-') {
			a -= 0.3;
		}
		System.out.println(a);
	}
}
