package SWEA;

import java.util.Scanner;

public class SWEA_1217 {
	
	static int TC = 10, T, N, M;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=TC; t++) {
			T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			pow(N, M, 0, 1);
		}
	}

	static void pow(int n, int m, int cnt, int mul) {
		if(cnt == M) {
			System.out.println("#" + T + " " + mul);
			return;
		}
		pow(n,m,cnt+1,mul*n);
	}
}
