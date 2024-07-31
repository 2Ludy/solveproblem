package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5597 {
	static int[] nums = new int[28];
	static int[] student = new int[30];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<28; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		for(int i=0; i<28; i++) {
			student[nums[i]-1] = 1;
		}
		for(int i=0; i<30; i++) {
			if(student[i] != 1) {
				System.out.println(i+1);
			}
		}
	}
}
