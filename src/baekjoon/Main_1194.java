package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {
	
	static int N, M, min;
	static int sr, sc;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][][][][][][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][2][2][2][2][2][2]; // N, M , a, b, c, d, e, f
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int status = 0;
		a : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					sr = i;
					sc = j;
					status++;
				}
				if(status == 2) break a;
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr, sc, 0, 0, 0, 0, 0, 0, 0});
		visited[sr][sc][0][0][0][0][0][0] = true;
		min = -1;
		
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int A = nums[2];
			int B = nums[3];
			int C = nums[4];
			int D = nums[5];
			int E = nums[6];
			int F = nums[7];
			int time = nums[8];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				
				if(map[nr][nc] == '#') continue;

				
				if(map[nr][nc] == 'a') {
					if(visited[nr][nc][1][B][C][D][E][F]) continue;
					visited[nr][nc][1][B][C][D][E][F] = true;
					que.offer(new int[] {nr, nc, 1, B, C, D, E, F, time+1});
					
				}else if(map[nr][nc] == 'b') {
					if(visited[nr][nc][A][1][C][D][E][F]) continue;
					visited[nr][nc][A][1][C][D][E][F] = true;
					que.offer(new int[] {nr, nc, A, 1, C, D, E, F, time+1});
					
				}else if (map[nr][nc] == 'c') {
					if(visited[nr][nc][A][B][1][D][E][F]) continue;
					visited[nr][nc][A][B][1][D][E][F] = true;
					que.offer(new int[] {nr, nc, A, B, 1, D, E, F, time+1});
					
				}else if (map[nr][nc] == 'd') {
					if(visited[nr][nc][A][B][C][1][E][F]) continue;
					visited[nr][nc][A][B][C][1][E][F] = true;
					que.offer(new int[] {nr, nc, A, B, C, 1, E, F, time+1});
					
				}else if (map[nr][nc] == 'e') {
					if(visited[nr][nc][A][B][C][D][1][F]) continue;
					visited[nr][nc][A][B][C][D][1][F] = true;
					que.offer(new int[] {nr, nc, A, B, C, D, 1, F, time+1});
					
				}else if (map[nr][nc] == 'f') {
					if(visited[nr][nc][A][B][C][D][E][1]) continue;
					visited[nr][nc][A][B][C][D][E][1] = true;
					que.offer(new int[] {nr, nc, A, B, C, D, E, 1, time+1});
					
				}else if (map[nr][nc] == 'A') {
					if(A > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'B') {
					if(B > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'C') {
					if(C > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'D') {
					if(D > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'E') {
					if(E > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'F') {
					if(F > 0) {
						if(visited[nr][nc][A][B][C][D][E][F]) continue;
						visited[nr][nc][A][B][C][D][E][F] = true;
						que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
					}else {
						continue;
					}
				
				}else if(map[nr][nc] == '1') {
					System.out.println(time+1);
					return;
				}else {
					if(visited[nr][nc][A][B][C][D][E][F]) continue;
					visited[nr][nc][A][B][C][D][E][F] = true;
					que.offer(new int[] {nr, nc, A, B, C, D, E, F, time+1});
				}
			}
		}
		System.out.println(min);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
