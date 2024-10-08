package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193 {
	
	static int T, N;
	static int[][] map;
	static int[][] visited;
	static int A, B, C, D;
	static int[][] stopped;
	static int min;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			 
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			min = 0;
			stopped = new int[N][N];
			
			bfs(A, B);
			min = min-1;
			System.out.println("#" + t + " " + min);
		}
	}

	static void bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr,sc});
		visited[sr][sc] = 1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			if(r==C && c == D) {
				min = visited[r][c];
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc] == 0) {
					int num = visited[r][c];
					if(map[nr][nc] == 0) {
						visited[nr][nc] = num+1;
					}
					if(map[nr][nc] == 2) {
						if((num-1+stopped[r][c])%3 == 0) {
							stopped[r][c]++;
							nr = r;
							nc = c;
						}else if((num-1+stopped[r][c])%3 == 1) {
							stopped[r][c]++;
							nr = r;
							nc = c;
						}else {   //  나머지가 2일때
							visited[nr][nc] = num+1+stopped[r][c];
						}
					}
					que.offer(new int[] {nr,nc}); 
				}
			}
		}
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
