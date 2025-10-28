package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_비트연산자 {
	
	static int N, M, min;
	static int sr, sc;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][64];
		
		
		// 0 0 0 0 0 >> 1 + 2 + 4 + 8 + 16 + 32 = 63 이니까 64로 초기화 f = 64 , current = 0
		// 열쇠 습득하면
		// 현재 0이니까 current = current | 1<<n (여기서 n은 A:0, B:1, C:2, D:3, E:4, F:5)
		// 만약에 문을 만난다면
		// current & 1<<n == current면 열쇠가 있다는거
		// current & 1<<n != current면 열쇠가 없다는거네
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		a : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					sr = i;
					sc = j;
					break a;
				}
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr, sc, 0, 0});
		visited[sr][sc][0] = true;
		min = -1;
		
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int r = nums[0];
			int c = nums[1];
			int current = nums[2];
			int time = nums[3];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == '#') continue;

				
				if(map[nr][nc] == 'a') {
					int newCurrent = current | 1<<0;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if(map[nr][nc] == 'b') {
					int newCurrent = current | 1<<1;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if (map[nr][nc] == 'c') {
					int newCurrent = current | 1<<2;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if (map[nr][nc] == 'd') {
					int newCurrent = current | 1<<3;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if (map[nr][nc] == 'e') {
					int newCurrent = current | 1<<4;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if (map[nr][nc] == 'f') {
					int newCurrent = current | 1<<5;
					if(visited[nr][nc][newCurrent]) continue;
					visited[nr][nc][newCurrent] = true;
					que.offer(new int[] {nr, nc, newCurrent , time+1});
					
				}else if (map[nr][nc] == 'A') {
					if((current & 1<<0) == 1<<0) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'B') {
					if((current & 1<<1) == 1<<1 ) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'C') {
					if((current & 1<<2) == 1<<2 ) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'D') {
					if((current & 1<<3) == 1<<3 ) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'E') {
					if((current & 1<<4) == 1<<4 ) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
					
				}else if (map[nr][nc] == 'F') {
					if((current & 1<<5) == 1<<5 ) {
						if(visited[nr][nc][current]) continue;
						visited[nr][nc][current] = true;
						que.offer(new int[] {nr, nc, current, time+1});
					}else {
						continue;
					}
				
				}else if(map[nr][nc] == '1') {
					System.out.println(time+1);
					return;
				}else {
					if(visited[nr][nc][current]) continue;
					visited[nr][nc][current] = true;
					que.offer(new int[] {nr, nc, current, time+1});
				}
			}
		}
		System.out.println(min);
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
