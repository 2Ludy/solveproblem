package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	
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
		} // map 생성 완+
		
		count = 0;
		
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			if(logic(i,0)) count++;
		}
		
		System.out.println(count);
		
	}
	
	static boolean logic(int r, int c) {
		
		if(c == C-1) {
			return true;
		}
		
		for(int d=0; d<3; d++) {
			int nr = r+dr[d];
			int nc = c+1;
		
			if(check(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if(logic(nr, nc)) {
					return true;
 				}
			}
		}
		return false;
	}

	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
