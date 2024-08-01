package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920 {
	
	static int[] nums; // 음표 배열
	static int count; // 카운트배열~~
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[8];
		count = 0;
		
		for(int i=0; i<8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] == i+1) {
				count++;
			}else if(nums[i] == 8-i) {
				count --;
			}
		}
		
		if(count == 8) {
			System.out.println("ascending");
		}else if(count == -8) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}
}
