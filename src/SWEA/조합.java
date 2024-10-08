package SWEA;

import java.util.Arrays;

public class 조합 {
	
	static int[] nums = {1,2,3,4,5,6,7};
	static int N = nums.length;
	static int R, count;
	static int[] combi;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		R = 3;
		combi = new int[R];
		visited = new boolean[N];
		count = 0;
		
		nPr(0,0);
		System.out.println(count);
		}


	static void nPr(int cnt, int idx) {
		if(cnt == R) {
			count++;
			System.out.println(Arrays.toString(combi));
			return;
		}
		
		for(int i=idx; i<N; i++) {
			combi[cnt] = nums[i];
			nPr(cnt+1, i+1);
		}
	}
}
