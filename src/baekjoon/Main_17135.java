package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135 {
	
	static int N, M, D;
	static int[][] map;
	static int[][] copy;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		copy = new int[N+1][M];
		count = 0;
		max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) count++;
			}
		}
		
		mC3(0,0);
		System.out.println(max);
	}

	private static void mC3(int idx, int cnt) {
		if(max == count) return;
		if(cnt == 3) {
			for(int i=0; i<N; i++) copy[i] = map[i].clone();
			game();
			return;
		}
		for(int j=idx; j<M; j++) {
			map[N][j] = 2;
			mC3(j+1,cnt+1);
			map[N][j] = 0;
		}
	}

	private static void game() {
		int army = count;
		int kill = 0;
		
		while(army > 0) {
			for(int j=0; j<M; j++) {
				if(map[N][j] == 2) {
					
				}
			}
		}
		max = Math.max(max, kill);
	}
}