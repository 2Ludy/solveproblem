package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 { 
	
	static int N, M, count;
	static boolean[][] map;
	static boolean[] visited;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		for(int k=0; k<M; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1-1][num2-1] = true;
			map[num2-1][num1-1] = true;
		} // 맵 생성
		
		visited = new boolean[N];
		count = 0;
		que = new LinkedList<>();
		que.offer(0);
		visited[0] = true;
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e=1; e<N; e++) {
				if(visited[e]) continue;
				if(map[s][e]) {
					que.offer(e);
					visited[e] = true;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
