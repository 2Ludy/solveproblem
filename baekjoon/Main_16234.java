package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {
	
	static int N, L, R;
	static int[][] popu;
	static boolean[][] visited;
	static int time;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		popu = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				popu[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 끝
		
		while(true) {
			boolean moved = false;
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					Queue<int[]> que = new LinkedList<>();
					Queue<int[]> pos = new LinkedList<>();
					int sum = popu[i][j];
					que.offer(new int[] {i,j});
					pos.offer(new int[] {i,j});
					visited[i][j] = true;
					while(!que.isEmpty()) {
						int[] nums = que.poll();
						int r = nums[0];
						int c = nums[1];
						for(int d=0; d<4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(!check(nr,nc)) continue;
							if(visited[nr][nc]) continue;
							if(!subpop(popu[r][c], popu[nr][nc])) continue;
							sum += popu[nr][nc];
							visited[nr][nc] = true;
							que.offer(new int[] {nr,nc});
							pos.offer(new int[] {nr,nc});
						}
					}
					if(pos.size() > 1) {
						moved = true;
						sum /= pos.size();
						while(!pos.isEmpty()) {
							int[] nums = pos.poll();
							int r = nums[0];
							int c = nums[1];
							popu[r][c] = sum;
						}
					}
				}
			}
			if(!moved) {
				System.out.println(time);
				break;
			}
			time++;
		}
		
	}

	private static boolean subpop(int p1, int p2) {
		int p = Math.abs(p1 - p2);
		return p >= L && p <= R;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}