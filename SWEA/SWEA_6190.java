package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6190 {
	
	static int T, N, max, mul, status;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			
			max = -1;
			
			for(int i = nums.length-1; i>=1; i--) {
				if(max > nums[i]*nums[i-1]) break;
				for(int j=i-1; j>=0 ; j--) {
					if(nums[i] % 10 != 0 && nums[j] % 10 != 0) {
						mul = nums[i]*nums[j];
						char[] chars = Integer.toString(mul).toCharArray();
						status = 0;
						for(int k=0; k<chars.length-1; k++) {
							if(chars[k] - chars[k+1] > 0 ) {
								status = 1;
								break;
							}
						}
						if(status == 0) {
							max = Math.max(max, mul);
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
    }
}
