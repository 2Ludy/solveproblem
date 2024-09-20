package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 { 
	
	static int N, M, year;
	static int[][] map;
	static int[][] copy;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			copy[i] = map[i].clone();
		} // map 생성 완.
		
		year = 0;
		
		while(true) {
			Queue<int[]> que = new LinkedList<>();
			int count = 0;
			int out = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] > 0) {
						count--;
						out++;
						if(count == -2) {
							System.out.println(year);
							return;
						}
						que.offer(new int[] {i,j});
						map[i][j] = count;
						while(!que.isEmpty()) {
							int[] nums = que.poll();
							int r = nums[0];
							int c = nums[1];
							
							for(int d=0; d<4; d++) {
								int nr = r+dr[d];
								int nc = c+dc[d];
								if(!check(nr,nc)) continue;
								if(map[nr][nc] <= 0) continue;
								map[nr][nc] = count;
								que.offer(new int[] {nr,nc});
							}
						}
					}
				}
			}
			
			if(out == 0) {
				System.out.println(0);
				return;
				
			}
			year++;
			
			for(int i=0; i<N; i++) {
				map[i] = copy[i].clone();
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] > 0) {
						int cou = 0;
						for(int d=0; d<4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(!check(nr,nc)) continue;
							if(map[nr][nc] != 0) continue;
							cou++;
						}
						int a = map[r][c] - cou;
						if(a < 0) a = 0;
						copy[r][c] = a;
					}
				}
			}
			for(int i=0; i<N; i++) {
				map[i] = copy[i].clone();
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
