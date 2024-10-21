package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {
	
	static int R, C, T;
	static int[][] map;
	static int[][] copy;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		copy = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) sr = i;
			}
		}
		
		int time = 0;
		while(time < T) {
			spreadDust();
			upAirCleaner();
			downAirCleaner();
			time++;
		}
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum+2);
	}

	private static void downAirCleaner() {
		copy[sr][1] = 0;
		for(int j=2; j<C; j++) {
			copy[sr][j] = map[sr][j-1];
		}
		for(int i=sr+1; i<R; i++) {
			copy[i][C-1] = map[i-1][C-1];
		}
		for(int j=C-2; j>=0; j--) {
			copy[R-1][j] = map[R-1][j+1];
		}
		for(int i=R-2; i>sr; i--) {
			copy[i][0] = map[i+1][0];
		}
		resultMap();
	}

	private static void upAirCleaner() {
		copy[sr-1][1] = 0;
		for(int j=2; j<C; j++) {
			copy[sr-1][j] = map[sr-1][j-1];
		}
		for(int i=sr-2; i>=0; i--) {
			copy[i][C-1] = map[i+1][C-1];
		}
		for(int j=C-2; j>=0; j--) {
			copy[0][j] = map[0][j+1];
		}
		for(int i=1; i<sr-1; i++) {
			copy[i][0] = map[i-1][0];
		}
		resultMap();
	}

	private static void spreadDust() {
		cloneMap();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					int count = 0;
					int dust = map[i][j]/5;
					for(int d=0; d<4; d++) {
						int r = i+dr[d];
						int c = j+dc[d];
						if(!check(r,c)) continue;
						if(map[r][c] == -1) continue;
						copy[r][c] += dust;
						count++;
					}
					copy[i][j] -= dust*count;
				}
			}
		}
		resultMap();
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

	private static void resultMap() {
		for(int i=0; i<R; i++) {
			map[i] = copy[i].clone();
		}
		
	}

	private static void cloneMap() {
		for(int i=0; i<R; i++) {
			copy[i] = map[i].clone();
		}
		
	}
}