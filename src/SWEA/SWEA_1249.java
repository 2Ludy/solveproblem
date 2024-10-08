package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249 {
	
	static class Road implements Comparable<Road> {
		int r, c, depth;

		public Road(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public int compareTo(Road o) {
			return this.depth - o.depth;
		}
	}
	
	static int T, N, time;
	static int[][] map;
	static int er, ec;
	static boolean[][] visited;
	static PriorityQueue<Road> que;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			er = N-1;
			ec = N-1;
			
			que = new PriorityQueue<>();
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				char[] cs = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					map[i][j] = cs[j]-'0';
				}
			}
			
			time = 0;
			visited[0][0] = true;
			que.offer(new Road(0, 0, 0));
			while(!que.isEmpty()) {
				Road r = que.poll();
				int cr = r.r;
				int cc = r.c;
				if(cr == er && cc == ec) break;
				for(int d=0; d<4; d++) {
					int nr = cr+dr[d];
					int nc = cc+dc[d];
					if(!check(nr,nc)) continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					map[nr][nc] += r.depth;
					que.offer(new Road(nr, nc, map[nr][nc]));
				}
			}
			time = map[er][ec];
			System.out.println("#" + t + " " + time);
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
