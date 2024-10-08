package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1949 {
	
	static int T, N, K, top;
	static int road, max;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	static Queue<int[]> que;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			top = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]);
				}
			}
			max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == top) {
						// 여기서 로직 하면 되는거 아닌감
						work(i, j, 1, true);
						}
					}
				}
			System.out.println("#" + t + " " + max);
			}
		}

	static void work(int r, int c, int dist, boolean skill) {
		if(dist > max) max = dist;
		
		visited[r][c] = true;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr,nc)) continue;
			if(visited[nr][nc]) continue;
			
			if(map[r][c] > map[nr][nc]) {
				work(nr,nc,dist+1, skill);
			}else if(skill && map[r][c] > map[nr][nc]-K) {
				int tmp = map[nr][nc];
				map[nr][nc] = map[r][c]-1;
				work(nr,nc,dist+1,false);
				map[nr][nc] = tmp;
			}
		}
		visited[r][c] = false;
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
