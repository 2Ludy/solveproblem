package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {
	
	static int[][] pan;
	static int[][] copyPan;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, count, time;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pan = new int[N][M];
		copyPan = new int[N][M];
		
		count = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j] == 1) {
					count++;
				}
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		pan[0][0] = 2;
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr,nc)) continue;
				if(pan[nr][nc] != 0) continue;
				pan[nr][nc] = 2;
				que.offer(new int[] {nr,nc});
			}
		}
		
		time = 0;
		while(count > 0) {
			clonePan();
			logic();
			time++;
			if(count == 0) break;
			reClonePan();
		}
		
		System.out.println(time);
	}

	private static void logic() {
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<M-1; c++) {
				if(pan[r][c] == 1) {
					int cnt = 0;
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(!check(nr,nc)) continue;
						if(pan[nr][nc] != 2) continue;
						cnt++;
					}
					if(cnt > 1) {
						copyPan[r][c] = 2;
						count--;
					}
				}
			}
		}
	}

	private static void reClonePan() {
		for(int i=0; i<N; i++) pan[i] = copyPan[i].clone();
	}

	private static void clonePan() {
		for(int i=0; i<N; i++) copyPan[i] = pan[i].clone();
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
