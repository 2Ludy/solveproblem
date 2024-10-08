package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382 {
	
	static int T, x1, y1, x2, y2;
	static int[] next = {1, -1};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+100;
			y1 = Integer.parseInt(st.nextToken())+100;
			x2 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			
			visited = new boolean[201][201][2];
			
			Queue<int[] > que = new LinkedList<>();
			que.offer(new int[] {x1, y1, 0, 0});
			que.offer(new int[] {x1, y1, 1, 0}); // 0은 가로, 1은 세로
			visited[x1][y1][0] = true;
			visited[x1][y1][1] = true;
			
			while(!que.isEmpty()) {
				int[] nums = que.poll();
				int x = nums[0];
				int y = nums[1];
				int s = nums[2];
				int distance = nums[3];
				
				if(x == x2 && y == y2) {
					System.out.println("#" + t + " " + distance);
					break;
				}

				if(s == 0) {
					for(int d=0; d<2; d++) {
						int nx = x+next[d];
						if(!check(nx)) continue;
						if(visited[nx][y][s]) continue;
						visited[nx][y][s] = true;
						que.offer(new int[] {nx, y, 1, distance+1});
					}
					
				}else if(s == 1) {
					for(int d=0; d<2; d++) {
						int ny = y+next[d];
						if(!check(ny)) continue;
						if(visited[x][ny][s]) continue;
						visited[x][ny][s] = true;
						que.offer(new int[] {x, ny, 0, distance+1});
					}
				}
			}
		}
	}

	static boolean check(int index) {
		return index>=0 && index<201;
	}
}
