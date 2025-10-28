package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231 {
	
	static int N, C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = 0;
		for(int i=N/2; i<N; i++) {
			if((i + i%10 + i%100/10 + i%1000/100 + i%10000/1000 + 
					i%100000/10000 + i%1000000/100000 + i/1000000) == N) {
				C = i;
				break;
			}
		}
		System.out.println(C);
	}
}
