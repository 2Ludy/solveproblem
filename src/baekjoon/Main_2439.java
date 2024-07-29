package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<N+1; i++) {
			for (int j=1; j<N+1-i; j++) {
				sb.append("\n");
			}
			sb.append("*");
		}
		
		System.out.print(sb.toString());
		
	}

}
