package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733 {
	
	static int T, N, max, maxCheese, index;
	static int[][] cheese, cheeseCopy;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			maxCheese = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxCheese = Math.max(cheese[i][j], maxCheese);
				}
			}
			max = 1;
			
			for(int k=1; k<maxCheese; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] == k) cheese[i][j] = 0;
					}
				}
				index = 0;
				visited = new boolean[N][N];
				que = new LinkedList<>();
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] == 0) continue;
						if(!visited[i][j]) {
							que.offer(new int[] {i,j});
							visited[i][j] = true;
							while(!que.isEmpty()) {
								int[] nums = que.poll();
								int r = nums[0];
								int c = nums[1];
								for(int d=0; d<4; d++) {
									int nr = r+dr[d];
									int nc = c+dc[d];
									if(!check(nr, nc)) continue;
									if(visited[nr][nc]) continue;
									if(cheese[nr][nc] == 0) continue;
									visited[nr][nc] = true;
									que.offer(new int[] {nr,nc});
								}
							}
							index++;
						}
					}
				} // 한번 끝
				max = Math.max(max, index);
			}
			System.out.println("#" + t + " " + max);
		}
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
