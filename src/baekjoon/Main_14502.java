package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	
	static int N, M;
	static int[][] map; 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int max, count;
	static List<int[]> list;
	static List<int[]> list2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					list.add(new int[] {i,j});
					count++;
				}else if(map[i][j] == 2) {
					list2.add(new int[] {i,j});
				}
			}
		}
		max = 0;
		
		nCr(0,0);
		System.out.println(max);
	}

	private static void nCr(int idx, int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i=idx; i<list.size(); i++) {
			int[] nums = list.get(i);
			int r = nums[0];
			int c = nums[1];
			map[r][c] = 1;
			nCr(idx+1, cnt+1);
			map[r][c] = 0;
		}
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[N][M];
		for(int i=0; i<list2.size(); i++) {
			que.offer(list2.get(i));
		}
		int infect = 0;
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc] != 0) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				infect++;
				que.offer(new int[] {nr, nc});
			}
		}
		int safe = count-infect-3;
		max = Math.max(safe, max);
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
