package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208 {
	
	static int T;
	static int dump;


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=10;
		for(int i=1; i<=T; i++) {
			dump = Integer.parseInt(br.readLine());
			int[] nums = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<100; j++) {
				nums[j] = Integer.parseInt(st.nextToken()); // 배열 값 넣기
			}
			int sub = 0;
			for(int k=0; k<dump; k++) {
				Arrays.sort(nums);   // 배열 정리
				nums[99]--;
				nums[0]++;
				sub = Math.max(nums[99], nums[98]) - Math.min(nums[1], nums[0]);
				if(sub < 0 ) {
					sub = 1;
					break;
				}else if(sub == 0) {
					break;
				}
			}
			System.out.println("#" + i +" " +sub);
		}

	}
}
