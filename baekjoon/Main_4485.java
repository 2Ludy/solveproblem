package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 { 
	
	static int N;
	static int er, ec, min;  
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map, value;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			map = new int[N][N];
			value = new int[N][N];
			visited = new boolean[N][N];	
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					value[i][j] = Integer.MAX_VALUE;
				}
			} // map 
			
			er = N-1;
			ec = N-1;
			
			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}});
			
			que.offer(new int[] {0, 0, map[0][0]});
			value[0][0] = map[0][0];
			while(!que.isEmpty()) {
				int[] nums = que.poll();
				int r = nums[0];
				int c = nums[1];
				int rupee = nums[2];
				if(visited[r][c]) continue;
				visited[r][c] = true;
				
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(!check(nr,nc)) continue;
					if(value[nr][nc] > rupee+map[nr][nc]) {
						que.offer(new int[] {nr, nc, rupee+map[nr][nc]});
						value[nr][nc] = rupee+map[nr][nc];
					}
				}
			}
			min = value[er][ec];
			System.out.println("Problem "+tc+": "+min);
			tc++;
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
