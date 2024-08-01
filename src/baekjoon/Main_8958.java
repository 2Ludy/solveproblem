package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958 { 
	
	static int T, total, plus;
	static char[] ox; // ox 배열
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			total = 0;
			plus = 0;
			ox = br.readLine().toCharArray(); // ox 생성
			for(int i=0; i<ox.length; i++) {
				if(ox[i] == 'O') {
					total += ++plus;
				} else {
					plus = 0;
				}
			}
			sb.append(total).append("\n");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
