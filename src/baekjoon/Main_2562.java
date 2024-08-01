package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_2562 {
	
	static final int N = 9;
	static int[] nums = new int[N];
	static int index;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = 0;
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if(nums[i] > max) {
				max = nums[i];
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
