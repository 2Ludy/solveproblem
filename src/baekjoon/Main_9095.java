package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_9095 {
	
	static int T, N;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		nums = new int[12];
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		nums[4] = 7;
		nums[5] = 13;
		nums[6] = 24;
		nums[7] = 44;
		nums[8] = nums[7] + nums[6] + nums[5];
		nums[9] = nums[8] + nums[7] + nums[6];
		nums[10] = nums[9] + nums[8] + nums[7];
		nums[11] = nums[10] + nums[9] + nums[8];

		StringBuilder sb = new StringBuilder();

		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(nums[N]).append("\n");
		}
		System.out.print(sb);
	}
}