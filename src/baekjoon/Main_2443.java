package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2443 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<2*N-i+1; j++) {   // 9 7 5 3 1 -> 2n-1개니까 2(N-i+1)-1 이넴
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
