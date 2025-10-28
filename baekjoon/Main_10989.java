package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10989 {
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[10000001]; // 인덱스는 0부터 시작하니
		
		for(int i=0; i<N; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				for(int j=0; j<nums[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}