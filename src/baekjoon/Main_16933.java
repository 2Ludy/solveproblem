package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16933 {

	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][K+1];
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[4] - o2[4];
			}
		}); 
		
		// r, c , k , 낮과밤(0 : 낮, 1: 밤), 거리
		que.offer(new int[] {0, 0, K, 0, 1});
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int k = nums[2]; 
			int t = nums[3];
			int dis = nums[4];
			if(r == N-1 && c == M-1) {
				System.out.println(dis);
				return;
			}
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == 0) {
					if(visited[nr][nc][k]) continue;
					visited[nr][nc][k] = true;
					que.offer(new int[] {nr, nc, k, (t+1)%2, dis+1});
				}else {
					if(k>0) {
						if(visited[nr][nc][k-1]) continue;
						if(t == 0) {
							que.offer(new int[] {nr, nc, k-1, 1, dis+1});
							visited[nr][nc][k-1] = true;
						}else {
							que.offer(new int[] {nr, nc, k-1, 1, dis+2});
							visited[nr][nc][k-1] = true;
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
