package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	
	static int N, M, min;
	static int sr, sc, er, ec;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sr = 0;
		sc = 0;
		er = N-1;
		ec = M-1;
		visited = new boolean[N][M][2];
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0, 0, 1, 1});
		visited[0][0][1] = true;
		min = -1;
		
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int punch = nums[2];
			int time = nums[3];
			if(r == er && c == ec ) {
				min = time;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == '1') {
					if(punch == 1) {
						if(visited[nr][nc][0]) continue;
						visited[nr][nc][0] = true;
						que.offer(new int[] {nr, nc, 0, time+1});
					}else { // punch 가 0
						continue;
					}
				}else {
					if(visited[nr][nc][punch]) continue;
					visited[nr][nc][punch] = true;
					que.offer(new int[] {nr, nc, punch, time+1});
				}
			}
		}
		System.out.println(min);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
