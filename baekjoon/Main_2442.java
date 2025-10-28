package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2442 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N-i; j++) {
				System.out.print(" ");
			}
			for(int j=N-i+1; j<N+i; j++) {  // N-i+1 부터 2i-1만큼... N+i
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
