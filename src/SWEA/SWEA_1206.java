package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			int tot=0;
			
			for(int j=0; j<N; j++) {
				nums[j] = sc.nextInt();
			}
			System.out.println(Arrays.toString(nums));
			
			for(int j=2; j<N-2; j++) {
				if(nums[j] > nums[j-1] && nums[j] > nums[j-2] && nums[j] > nums[j+1] && nums[j] > nums[j+2]) {
					tot += nums[j]-Math.max(Math.max(nums[j-1], nums[j-2]), Math.max(nums[j+1], nums[j+2]));
				}
			}
			System.out.println("#" + i + " " + tot);
		}
	}
}
