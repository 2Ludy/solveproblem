package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17142 {
	
	static int N, M;
	static int[][] map;
	static int[][] clone;
	static List<int[]> virus;
	static int size;
	static int[] p;
	static int count;
	static int min;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		map = new int[N][N];
		clone = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) { // 갈 수 있는곳
					map[i][j] = -1;
					count++;
				}else if(num == 1) { // 못가는벽
					map[i][j] = -2;
				}else { // 바이러스를 놓을 수 있는 위치
					virus.add(new int[] {i,j});
					map[i][j] = -3;
				}
			}
		}
		if(count == 0) {
			System.out.println(0);
			return;
		}
		size = virus.size();
		p = new int[M];
		
		nCr(0,0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	private static void nCr(int idx, int cnt) {
		if(cnt == M) {
			bfs();
			return;
		}
		for(int i=idx; i<size; i++) {
			p[cnt] = i;
			nCr(i+1, cnt+1);
		}
		
	}

	private static void bfs() {
		int cnt = 0;
		int time = 0;
		for(int i=0; i<N; i++) clone[i] = map[i].clone();
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for(int i=0; i<M; i++) {
			int[] nums = virus.get(p[i]);
			int r = nums[0];
			int c = nums[1];
			clone[r][c] = 0;
			que.offer(new int[] {r,c,0});
		}
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int t = nums[2];
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr,nc)) continue;
				if(!(clone[nr][nc] == -1 || clone[nr][nc] == -3)) continue;
				if(clone[nr][nc] == -1) {
					clone[nr][nc] = t+1;
					que.offer(new int[] {nr, nc, t+1});
					cnt++;
				}else {
					clone[nr][nc] = t+1;
					que.offer(new int[] {nr, nc, t+1});
				}
			}
			if(cnt == count) {
				min = Math.min(min, t+1);
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}