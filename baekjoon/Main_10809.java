package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809 { 
	
	static char[] cs;
	static int[] alpha;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alpha = new int[26]; // 알파벳 총 26개
		Arrays.fill(alpha, -1);
		cs = br.readLine().toCharArray();
		for(int i=0; i<cs.length; i++) {
			if(alpha[cs[i]-'a'] == -1) {
				alpha[cs[i]-'a'] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<alpha.length; i++) {
			sb.append(alpha[i]).append(" ");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
