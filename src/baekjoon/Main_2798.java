package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {
	
	static int N, M, hap, max;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		
		hap = 0;
		max = 0;
		
		for(int i=0; i<=N-3; i++) {
			for(int j=i+1; j<=N-2; j++) {
				for(int k=j+1; k<=N-1; k++) {
					hap = nums[i]+nums[j]+nums[k];
					if(hap <= M && max < hap) {
						max = hap;
					}
				}
			}
		}
		System.out.println(max);
	}
}
