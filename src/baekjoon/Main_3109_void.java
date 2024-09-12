package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_void {
	
	static int R, C, count, status;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static boolean[][] visited;
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		} // map 생성 완
		
		count = 0;
		
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			status = 0;
			logic(i,0);
		}
		
		System.out.println(count);
		
	}
	
	static void logic(int r, int c) {
		
		if(c == C-1) {
			count++;
			status = 1;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int nr = r+dr[d];
			int nc = c+1;
		
			if(check(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				logic(nr, nc);
				if(status == 1) return;
			}
		}
	}	

	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
