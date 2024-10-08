package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289 {
	
	static int T, N, count;
	static int[] nums;
	static char[] chars;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			chars = br.readLine().toCharArray(); // 캐릭터형으로 받기
			nums = new int[chars.length];
			count = 0;
			for(int i=0; i<chars.length; i++) {
				if(chars[i] - '0' != nums[i]) {
					for(int j=i; j<chars.length; j++) {
						if(nums[j] == 0) {
							nums[j] = 1;
						}else if(nums[j] == 1) {
							nums[j] = 0;
						}
					}
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
    }
}
