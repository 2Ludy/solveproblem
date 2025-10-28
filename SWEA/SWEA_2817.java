package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817 {
	
	static int T, N, K, count;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			nCr(0, 0);
			System.out.println("#" + t + " " + count);
		}
	}

	private static void nCr(int cnt, int hap) {
		if(hap >= K || cnt >= N) {
			if(hap == K) {
				count++;
			}
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			nCr(i+1, hap+nums[i]);
		}
	}
}
