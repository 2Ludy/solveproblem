package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2577 { 
	
	static int A, B, C, mul;
	static int[] nums; // 0부터 9 카운팅 할 크기 10짜리 배열
	static char[] cs; // 곱 숫자를 담을 char 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[10];
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		mul = A*B*C;
		
		cs = Integer.toString(mul).toCharArray();
		
		for(int i=0; i<cs.length; i++) {
			nums[cs[i]-'0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<nums.length; i++) {
			sb.append(nums[i]).append("\n");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
