package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656 {
	
	static int N, M;
	static StringBuilder sb;
	static int[] p, nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		p = new int[M];
		sb = new StringBuilder();
		
		nHr(0);
		System.out.println(sb);
	}

	static void nHr(int idx) {
		if(idx == M) {
			for(int num : p) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			p[idx] = nums[i];
			nHr(idx+1);
			p[idx] = 0;
		}
	}
}
