package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663 {
	
	static int N, count;
	static int[][] chess;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		
		count = 0;
		nqueen(0,0);
		System.out.println(count);
	}

	static void nqueen(int cnt, int c) {
		if(cnt == N) {
			
		}
	}
}