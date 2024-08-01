package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_3052 {
	
	static final int N = 10;
	static int[] nums = new int[42];
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = 0;
		for(int i=0; i<N; i++) {
			nums[Integer.parseInt(br.readLine())%42] = 1;
		}
		
		for(int i=0; i<42; i++) {
			if(nums[i] == 1)
				count++;
		}
		System.out.println(count);
	}
}