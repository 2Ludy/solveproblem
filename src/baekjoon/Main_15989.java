package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15989 {
	
	static int T;
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			if(N<4) {
				nums = new int[4];
			}else {
				nums = new int[N+1];
			}
			
			nums[1] = 1; // 1
			nums[2] = 2; // 1+1 , 2
			nums[3] = 3; // 1+1+1, 2+1, 3
			nums[4] = 4; // 1+1+1+1, 1+1+2, 2+2, 1+3;
			nums[5] = 5; // 1+1+1+1+1, 1+1+1+2, 1+2+2, 1+1+3, 2+3;
			nums[6] = 7; // 1+1+1+1+1+1, 1+1+1+1+2, 1+1+2+2, 2+2+2, 1+1+1+3, 3+3, 1+2+3
			nums[7] = 8; // 1+1+1+1+1+1+1, 1+1+1+1+1+2, 1+1+1+2+2, 1+2+2+2, 1+1+1+1+3, 1+3+3, 1+1+2+3, 2+2+3
			nums[8] = 10; // 1+1+1+1+1+1+1+1, 1+1+1+1+1+1+2, 1+1+1+1+2+2, 1+1+2+2+2, 2+2+2+2, 1+1+1+1+1+3, 1+1+3+3, 2+3+3, 1+1+1+2+3, 1+2+2+3
			
			
			// 1 + 10/2 = 5 + 10/3 = 3
			// 10/5 = 2, 10/7 = 1, 10/8 = 1, 10/9 = 1
			// 2,3 = 2+3+2 = 7  2+3+3 = 8 2+3+3+2 = 10
			// 5부터 
			
			// 6   1 + 3 + 2 + 1 = 7
			// 5   1 + 2 + 1 + 1 = 5
		}
	}
}
