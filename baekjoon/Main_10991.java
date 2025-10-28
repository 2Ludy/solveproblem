package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10991 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N-i; j++) {
				sb.append(" ");
			}
			sb.append("*");
			
			for(int j=1; j<i; j++) {
				sb.append(" *");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}