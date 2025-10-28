package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1966 {
	
	static int T, N;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t);
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			
			for(int i=0; i<N; i++) {
				sb.append(" ").append(nums[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
