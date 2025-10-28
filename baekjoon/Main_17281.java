package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17281 {
	
	static int N;
	static boolean[] visited;
	static int[] players;
	static int[][] scores;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		scores = new int[N][9];
		visited = new boolean[9];
		players = new int[9];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		baseball(0);
	}

	static void baseball(int cnt) {
		if(cnt == 9) {
			return;
		}
		
		if(cnt == 3) {
			players[cnt] = cnt;
		}
		
		for(int i=1; i<9; i++) {
			if(visited[i]) continue;
			
		}
	}
}