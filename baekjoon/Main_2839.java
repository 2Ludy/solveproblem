package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839 {
	
	static int N, limited, min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		limited = N/3 + 1;
		min = limited;
		
		logic(0, N);
		if(min == limited) min = -1; 
		System.out.println(min);
	}

	static void logic(int cnt, int n) {
		if(cnt >= min || n<0) return;
		if(n == 0) {
			min = Math.min(min, cnt);
			return;
		}
		if(n<=30) {
			logic(cnt+1, n-5);
			logic(cnt+1, n-3);
		}else {
			logic(cnt+(n-15)/5, (n-15)%5+15);
		}
		
	}
}
