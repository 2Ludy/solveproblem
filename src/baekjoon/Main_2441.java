package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2441 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<=N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
