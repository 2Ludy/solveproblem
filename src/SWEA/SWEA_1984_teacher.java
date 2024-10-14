package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1984_teacher {
	
	static int T;
	static int[] nums;
	static int N = 10;
	static int max,min;
	static double sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<= T; t++) {
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			max = -1000000;
			min = 1000000;
			sum=0.0;
			for(int i=0; i<N; i++) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i]);
				sum+=nums[i];
			}
			System.out.printf("#%d %.0f\n",t,(sum-max-min)/(N-2));
		}
	}
}