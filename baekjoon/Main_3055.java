package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
	
	static int R, C;
	static int sr, sc;
	static int[][] map;   // . : 0, S : 시작점, * : 1, X : 2, D : 3
	static int[][] mapFlood;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		mapFlood = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			char[] cs = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(cs[j] == '*') {
					map[i][j] = 1;
				}else if(cs[j] == 'X') {
					map[i][j] = 2;
				}else if(cs[j] == 'D') {
					map[i][j] = 3;
				}else if(cs[j] == 'S') {
					sr = i;
					sc = j;
				}
			}
			mapFlood[i] = map[i].clone();
		} // 생성
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			flood();
			for(int i=0; i<size; i++) {
				int[] nums = que.poll();
				int r = nums[0];
				int c = nums[1];
				int dis = nums[2];
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc]== 3) {
						System.out.println(dis+1);
						return;
					}
					if(map[nr][nc]== 1)continue;
					if(map[nr][nc]== 2)continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc, dis+1});
				}
			}
		}
		System.out.println("KAKTUS");
	}


	static void flood() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 1) {
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(!check(nr,nc)) continue;
						if(map[nr][nc] == 0) mapFlood[nr][nc] = 1;
					}
				}
			}
		}
		
		for(int r=0; r<R; r++) map[r] = mapFlood[r].clone();
	}


	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
