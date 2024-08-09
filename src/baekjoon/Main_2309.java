package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2309 {
	
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9];
		for(int i=0; i<9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		
	}
}
