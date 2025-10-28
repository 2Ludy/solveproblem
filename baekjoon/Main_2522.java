package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2522 { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<2*N; i++) {
			for(int j=1; j<=Math.abs(N-i); j++) {
				sb.append(" ");
			}
			for(int j=1; j<=N-Math.abs(N-i); j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
