package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_31495 {
	
	static String s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		char c1 = s.charAt(0);
		char c2 = s.charAt(s.length()-1);
		
		if(c1 == '\"' && c2 == '\"') {
			for(int i=1; i<s.length()-1; i++) {
				char c = s.charAt(i);
				if(c != ' ') {
					StringBuilder sb = new StringBuilder();
					for(int j=1; j<s.length()-1; j++) {
						sb.append(s.charAt(j));
					}
					System.out.println(sb);
					return;
				}
			}
		}
		System.out.println("CE");
	}
}
