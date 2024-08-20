package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
	
	static int[] nums;
	static int[] seven;
	static int count;
	static int hap;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9];
		
		for(int i=0; i<9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		seven = new int[7];
		
		nCr(0,0);
		Arrays.sort(seven);
		
		for(int num : seven) {
			System.out.println(num);
		}
	}

	private static void nCr(int cnt, int start) {
		if(cnt == 7) {
			hap = 0;
			for(int a : seven) {
				hap += a;
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			if(hap == 100) return;
			seven[cnt] = nums[i];
			nCr(cnt+1,i+1);
		}
	}
}
