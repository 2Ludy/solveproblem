package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793 {
	
	static int T;
	static int N, M, sr, sc;
	static int[][] map; // S : 현재 위치, D : 3, . : 0, X : 2, * : 1
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		a : for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				char[] cs = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(cs[j] == '*') {
						map[i][j] = 1;
					}else if(cs[j] == 'X') {
						map[i][j] = 2;
					}else if(cs[j] == 'S') {
						sr = i;
						sc = j;
					}else if(cs[j] == 'D') {
						map[i][j] = 3;
					}
				}
			} // map 생성
			
			Queue<int[]> move = new LinkedList<>();
			Queue<int[]> devil = new LinkedList<>();
			
			move.offer(new int[] {sr, sc, 0});
			visited[sr][sc] = true;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) devil.offer(new int[] {i, j});
				}
			}
			
			while(!move.isEmpty()) {
				int size1 = devil.size();
				for(int i=0; i<size1; i++) {
					int[] nums = devil.poll();
					int r = nums[0];
					int c = nums[1];
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(!check(nr,nc)) continue;
						if(map[nr][nc] != 0) continue;
						map[nr][nc] = 1;
						devil.offer(new int[] {nr, nc});
					}
				} // devil 채우기
				
				
				int size2 = move.size();
				for(int i=0; i<size2; i++) {
					int[] nums = move.poll();
					int r = nums[0];
					int c = nums[1];
					int dis = nums[2];
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(!check(nr,nc)) continue;
						if(map[nr][nc] == 3) {
							System.out.println("#" + t + " " + (dis+1));
							continue a;
						}
						if(map[nr][nc] != 0) continue;
						if(visited[nr][nc]) continue;
						
						visited[nr][nc] = true;
						move.offer(new int[] {nr, nc, dis+1});
					}
				}
			}
			System.out.println("#" + t + " " + "GAME OVER");
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
