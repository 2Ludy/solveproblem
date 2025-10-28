package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1546 {
	
	static int T;
	static double total;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		nums = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<T; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		Arrays.sort(nums);
		System.out.println(total/nums[nums.length-1]*100/T);
		
	}
}
