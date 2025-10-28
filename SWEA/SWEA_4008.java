package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008 {
	
	static int T, N, max, min;
	static int[] oper, nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			oper = new int[4];
			for(int i=0; i<4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}// 0 : +(더하기), 1 : -(빼기), 2 : *(곱셈), 3 : /(나누기)
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			max = -10000000;
			min = 10000000;
			
			logic(1, nums[0], oper[0], oper[1], oper[2], oper[3]);
			System.out.println("#"+t+" "+(max-min));
			
		}
	}

	static void logic(int cnt, int sum, int hap, int sub, int mul, int div) {
		if(cnt == N) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		if(hap > 0) {
			logic(cnt+1, sum+nums[cnt], hap-1, sub, mul, div);
		}
		if(sub > 0) {
			logic(cnt+1, sum-nums[cnt], hap, sub-1, mul, div);
		}
		if(mul > 0) {
			logic(cnt+1, sum*nums[cnt], hap, sub, mul-1, div);
		}
		if(div > 0) {
			logic(cnt+1, sum/nums[cnt], hap, sub, mul, div-1);
		}
	}
}
