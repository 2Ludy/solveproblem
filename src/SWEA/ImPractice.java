package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImPractice {
	
	static int T, N, count;
	static int[] nums, light;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[N];
			light = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			for(int i=0; i<N; i++) {
				if(nums[i] != light[i]) {
					count++;
					for(int j=i; j<N; j=j+i+1) {
						if(light[j] == 0) {
							light[j] = 1;
						}else {
							light[j] = 0;
						}
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
