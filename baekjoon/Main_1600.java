package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	
	static int K, W, H, min; // H가 행, W가 열
	static int er, ec;
	static int[][] map;
	static boolean[][][] visited;
	static int[] horseR = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] horseC = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] monkeyR = {-1, 0, 1, 0};
	static int[] monkeyC = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		er = H-1;
		ec = W-1;
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = -1;
		Queue<int[]> que = new LinkedList<>(); // r, c, k, distance
		que.offer(new int[] {0, 0, K, 0});
		for(int i=0; i<K+1; i++) {
			visited[0][0][i] = true;
		}
		
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int k = nums[2];
			int time = nums[3];
			
			if(r == er && c == ec) {
				min = time;
				break;
			}
			
			if(k>0) { // 말
				for(int d=0; d<8; d++) {
					int dr = r + horseR[d];
					int dc = c + horseC[d];
					
					if(!check(dr,dc)) continue;
					if(visited[dr][dc][k-1]) continue;
					if(map[dr][dc] == 1) continue;
					visited[dr][dc][k-1] = true;
					que.offer(new int[] {dr, dc, k-1, time+1});
				}
			}
			
			for(int d=0; d<4; d++) { // 몽키
				int dr = r + monkeyR[d];
				int dc = c + monkeyC[d];
				
				if(!check(dr,dc)) continue;
				if(visited[dr][dc][k]) continue;
				if(map[dr][dc] == 1) continue;
				visited[dr][dc][k] = true;
				que.offer(new int[] {dr, dc, k, time+1});
			}
		}
		
		
		System.out.println(min);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
