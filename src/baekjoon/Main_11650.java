package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650 {
	
	static int N;
//	static String[] strs;
	static int[][] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		strs = new String[N];
//		
//		for(int i=0; i<N; i++) {
//			strs[i] = br.readLine();
//		}
//		
//		Arrays.sort(strs, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				StringTokenizer o1s = new StringTokenizer(o1);
//				StringTokenizer o2s = new StringTokenizer(o2);
//				int o11 = Integer.parseInt(o1s.nextToken());
//				int o12 = Integer.parseInt(o1s.nextToken());
//				int o21 = Integer.parseInt(o2s.nextToken());
//				int o22 = Integer.parseInt(o2s.nextToken());
//				if(o11 == o21) {
//					return o12 - o22;
//				}
//				return o11 - o21;
//			}
//		});
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<strs.length; i++) {
//			sb.append(strs[i]).append("\n");
//		}
		nums = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums, (num1, num2) -> {
			if(num1[0] == num2[0]) {
				return num1[1] - num2[1];
			}
			return num1[0] - num2[0];
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(nums[i][0]).append(" ").append(nums[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}