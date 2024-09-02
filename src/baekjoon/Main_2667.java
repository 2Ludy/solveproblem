package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
	
	static int[][] map;
	static int N, index;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		index = 1;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					//여기서 logic 시작
					bfs(r, c, ++index);
				}
			}
		}
		
		count = new int[index-1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=2; k<=index; k++) {
					if(map[i][j] == k) {
						count[k-2]++;
					}
				}
			}
		}
		
		Arrays.sort(count);
		
		StringBuilder sb = new StringBuilder();
		sb.append(index-1).append("\n");
		for(int num : count) {
			sb.append(num).append("\n");
		}
		System.out.print(sb);
		
	}

	static void bfs(int sr, int sc, int idx) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr,sc});
		map[sr][sc] = idx;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] != 1) continue;
				map[nr][nc] = idx;
				que.offer(new int[] {nr, nc});
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
