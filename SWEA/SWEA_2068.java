package SWEA;

import java.util.Scanner;

public class SWEA_2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int nums[] =new int[10];
		
		for(int i=1; i<=T; i++) {
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
			System.out.println("#"+ i +" "+nums[9]);
		}
	}

}