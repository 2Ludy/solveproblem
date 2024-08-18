package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491 {
	
	static int N, icount, dcount, max;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 2;
		icount = 1;
		dcount = 1;
		
		for(int i = 0; i<N-1; i++) {
			if(nums[i] >= nums[i+1]) {
				dcount++;
			} else {
				dcount = 1;
			}
			
			if(nums[i] <= nums[i+1]) {
				icount++;
			}else {
				icount = 1;
			}
			
			max = Math.max(max, Math.max(icount, dcount));
		}
		
		System.out.println(max);
	}
}
