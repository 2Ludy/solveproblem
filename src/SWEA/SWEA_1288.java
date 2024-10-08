package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_1288 {
	
	static int T, N, i, number;
	static char[] chars;
	static Set<Character> sheep;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			sheep = new HashSet<>();
			i=0;
			while(sheep.size() < 10) {
				number = ++i*N;
				chars = Integer.toString(number).toCharArray();
				
				for(int i=0; i < chars.length; i++) {
					sheep.add(chars[i]);
				}
			}
			System.out.println("#" + t + " " + number);
		}
    }
}
