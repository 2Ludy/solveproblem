package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663 {
	
	static int N;
	static int[] chess;
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		chess = new int[N];
			
		count = 0;
		queen(0);
		System.out.println(count);
	}

	static void queen(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(check(i, idx)) {
				chess[idx] = i;
				queen(idx+1);
			}
		}
	}

	static boolean check(int r, int idx) {
		for(int i=0; i<idx; i++) {
			if(chess[i] == r || Math.abs(chess[i]-r) == Math.abs(idx-i)) return false;
		}
		return true;
	}
}