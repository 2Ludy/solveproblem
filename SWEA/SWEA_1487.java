package SWEA;

import java.util.Scanner;

public class SWEA_1487 {
	
	static int T, N, W, count;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			nums = new int[N]; 
			
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			count = 0;
			nCr(0, 0);
			System.out.println(count);
		}
	}

	static void nCr(int cnt, int hap) {
		if(hap >= W || cnt >= N) {
			if(hap == W) count++;
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			nCr(i+1, hap+nums[i]);
		}
	}
}
