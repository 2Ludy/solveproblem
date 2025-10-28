package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10974 {
	
	static int N;
	static int[] nums;
	 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		StringBuilder sb = new StringBuilder();
		do {
			for(int num: nums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		} while (NP(N-1));
		
		System.out.println(sb);
	}


	static boolean NP(int size) {
		int i = size;
		while(i>0 && nums[i-1] >= nums[i]) i--;
		if(i==0) return false;
		int j = size;		
		while(nums[i-1]>=nums[j]) j--;
		int tmp = nums[i-1];
		nums[i-1] = nums[j];
		nums[j] = tmp;
		int k = size;
		while(i<k) {
			tmp = nums[i];
			nums[i] = nums[k];
			nums[k] = tmp;
			i++;
			k--;
		}
		return true;
	}
}