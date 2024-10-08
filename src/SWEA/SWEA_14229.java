package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14229 {
	
	static int T, N, k;
	static int[] nums, sorts;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[1000001];
		for(int i=1; i<=1000000; i++) {
			nums[Integer.parseInt(st.nextToken())]++;
		}
		
		sorts = new int[1000000];
		k = 0;
		for(int i=0; i<1000001; i++) {
			if(nums[i] != 0) {
				for(int j=1; j<=nums[i]; j++) {
					sorts[k++] = i;
				}
			}
			if(sorts[500000] != 0) {
				System.out.println(sorts[500000]);
				break;
			}
		}
	}
}
