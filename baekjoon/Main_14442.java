package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442 {
	
	static int N, M, K;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0, 0, K, 1});
		visited[0][0][K] = true;
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int k = nums[2];
			int distance = nums[3];
			if(r == N-1 && c == M-1) {
				System.out.println(distance);
				return;
			}
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == '1') {
					if(k>0) {
						if(visited[nr][nc][k-1]) continue;
						visited[nr][nc][k-1] = true;
						que.offer(new int[] {nr, nc, k-1, distance+1});
					}else {
						continue;
					}
				}else if(map[nr][nc] == '0') {
					if(visited[nr][nc][k]) continue;
					visited[nr][nc][k] = true;
					que.offer(new int[] {nr, nc, k, distance+1});
				}
			}
		}
		System.out.println(-1);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
