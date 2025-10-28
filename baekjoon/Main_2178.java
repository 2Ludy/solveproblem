package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = chars[j]-'0';
			}
		}
		N--;
		M--;
		System.out.println(bfs(0,0));
	}

	static int bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr,sc});
		visited[sr][sc] = 1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			if(r==N && c==M) {
				return visited[r][c];
			}
			for(int d=0; d<4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(!check(nr,nc) || visited[nr][nc] != 0) continue;
				if(map[nr][nc] == 1) {
					que.offer(new int[] {nr,nc});
					visited[nr][nc] = visited[r][c]+1;
				}
			}
		}
		return -1;
	}

	static boolean check(int r, int c) {
		return 0<=r && r<=N && 0<=c && c<=M;
	}
}
