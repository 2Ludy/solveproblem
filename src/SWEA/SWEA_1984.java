package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1984 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int nums[] =new int[10];
		int tot;
		
		for(int i=1; i<=T; i++) {
			tot=0;
			for(int j=0; j<=9; j++) {
				nums[j] = sc.nextInt();
			}
			for(int k=9; k>=0; k--) {
				for(int j=0; j<k; j++) {
					if(nums[j] > nums[j+1]) {
						int tmp = nums[j+1];
						nums[j+1] = nums[j];
						nums[j] = tmp;
					}
				}
			}
			System.out.println(Arrays.toString(nums));
			for(int n=1; n<=8; n++) {
				tot += nums[n];
			}
			int avg = (int)Math.round((double)tot/8);
			System.out.println("#"+ i +" "+avg);
		}
	}
}