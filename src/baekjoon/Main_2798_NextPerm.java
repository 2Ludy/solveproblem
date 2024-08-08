package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2798_NextPerm {
	
	static int N, M, hap, max;
	static int[] nums;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		p = new int[N];
		Arrays.fill(p, 1);
		for(int i=0; i<N-3; i++) {
			p[i] = 0;
		}
		
		hap = 0;
		max = 0;
		
		do {
			int r = 0;
			for(int i=0; i<N; i++) {
				if(p[i] == 1) {
					r += nums[i];
				}
			}
			if(r<=M) {
				max = Math.max(r, max);
			}
		} while (np(N-1));
		System.out.println(max);
	}

	static boolean np(int size) {
		int i = size;
		while(i>0 && p[i-1]>= p[i]) i--;
		if(i==0) return false;
		int j = size;
		while(p[i-1]>=p[j]) j--;
		int tt = p[i-1];
		p[i-1] = p[j];
		p[j] = tt;
		int k = size;
		while(i<k) {
			tt = p[i];
			p[i] = p[k];
			p[k] = tt;
			i++;
			k--;
		}
		return true;
	}
}
