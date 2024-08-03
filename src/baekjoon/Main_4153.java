package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4153 { 
	
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[3];
			
			nums[0] = Integer.parseInt(st.nextToken());
			nums[1] = Integer.parseInt(st.nextToken());
			nums[2] = Integer.parseInt(st.nextToken());
		
			if(nums[0] == 0 && nums[0] == 0 && nums[0] == 0) {
				break;
			}
			
			Arrays.sort(nums);
			
			
			if( nums[0]*nums[0] + nums[1]*nums[1] == nums[2]*nums[2]) {
				sb.append("right").append("\n"); 
			}else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.println(sb);
	}
}
