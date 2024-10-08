package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2806 {
	
	static int T, N;
	static int[][] chess;
	static int count;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 8방
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			chess = new int[N][N];
			
			count = 0;
			queen(0);
			System.out.println("#" + t + " " + count);
		}
	}

	static void queen(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		
		a : for(int j=0; j<N; j++) {
			for(int k=1; k<N; k++) {
				for(int d=0; d<8; d++) {
					int nr = idx + k*dr[d];
					int nc = j + k*dc[d];
					if(!check(nr, nc)) continue;
					if(chess[nr][nc] == 1) continue a;
				}
			}
			chess[idx][j] = 1;
			queen(idx+1);
			chess[idx][j] = 0;
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
