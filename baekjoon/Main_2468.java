package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 { 
	
	static int N, count, maxCount, maxH;
	static int[][] map;
	static int[][] copy;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copy = new int[N][N];
		
		maxH = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(map[i][j], maxH);
			}
		} // 맵 생성 완
		
		maxCount = 1;
		
		for(int d=1; d<=maxH; d++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] <= d) {
						copy[i][j] = 0;
					}else {
						copy[i][j] = -1;
					}
				}
			} // copy 생성 완
			count = 0;
			
			Queue<int[]> que = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if(copy[i][j] == -1) {
						++count;
						que.offer(new int[] {i,j});
						while(!que.isEmpty()) {
							int[] nums = que.poll();
							int r = nums[0];
							int c = nums[1];
							for(int k=0; k<4; k++) {
								int nr = r+dr[k];
								int nc = c+dc[k];
								if(!check(nr,nc)) continue;
								if(copy[nr][nc] != -1) continue;
								copy[nr][nc] = count;
								que.offer(new int[] {nr,nc});
							}
						}
					}
					maxCount = Math.max(maxCount, count);
				}
			}
		}
		System.out.println(maxCount);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
