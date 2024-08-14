package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 { 
	
	static int K, hap, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int[] nums = new int[6];
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			nums[i] = Integer.parseInt(st.nextToken());
		}
		hap = nums[0]*nums[5];
		max = hap;
		
		for(int i=0; i<5; i++) {
			hap += nums[i]*nums[i+1];
			max = Math.max(max, nums[i]*nums[i+1]);
		}
		
		System.out.println((hap-2*max)*K);
	}
}
