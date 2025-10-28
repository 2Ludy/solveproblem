package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2063 {
	
	static int T;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(br.readLine());
		int[] nums = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<T; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		System.out.println(nums[T/2]);
	}
}
