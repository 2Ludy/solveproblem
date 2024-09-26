package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2747 {
	
	static int N;
	static int[] fibo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fibo = new int[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i=2; i<=N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[N]);
	}
}

