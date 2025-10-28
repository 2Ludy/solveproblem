package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	
	static int N, M, V;
	static boolean[] bvisited, dvisited;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		bvisited = new boolean[N+1];
		dvisited = new boolean[N+1];
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		sb = new StringBuilder();
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(v);
		bvisited[v] = true;
		sb.append(v).append(" ");
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e=1; e<N+1; e++) {
				if(bvisited[e]) continue;
				if(map[s][e] == 1) {
					que.offer(e);
					bvisited[e] = true;
					sb.append(e).append(" ");
				}
			}
		}
		
	}

	static void dfs(int s) {
		dvisited[s] = true;
		sb.append(s).append(" ");
		for(int e=1; e<N+1; e++) {
			if(dvisited[e]) continue;
			if(map[s][e] == 1) {
				dfs(e);
			}
		}
	}
}
