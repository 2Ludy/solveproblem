package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {
	
	static int N, M;
	static int sr, sc, d;
	static int count;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		while(true) {
			if(map[sr][sc] == 0) {
				map[sr][sc] = 1;
				count++;
			}else {
				int clean = 0;
				for(int k=0; k<4; k++) {
					int nr = sr + dr[k];
					int nc = sc + dc[k];
					if(map[nr][nc] == 0) clean++;
				}
				if(clean == 0) {
					int nr = sr+dr[(d+2)%4];
					int nc = sc+dc[(d+2)%4];
					if(map[nr][nc] == 0) {
						sr = nr;
						sc = nc;
					}else {
						System.out.println(count);
						return;
					}
				}else {
					int tmpr = sr;
					int tmpc = sc;
					while(tmpr==sr && tmpc==sc) {
						d = d-1;
						if(d == -1) d = 3;
						int nr = sr+dr[d];
						int nc = sc+dc[d];
						if(map[nr][nc] == 0) {
							sr = nr;
							sc = nc;
							break;
						}
					}
				}
			}
		}
	}
}
