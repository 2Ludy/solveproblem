package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644 {
	
	static int N, p1, p2, M, count;
	static int[][] family;
	static boolean[] visited;  
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken())-1;
		p2 = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(br.readLine());
		
		family = new int[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			family[num1][num2] = 1;
			family[num2][num1] = 1;
		}
		
		count = 1;
		
		visited = new boolean[N];
		Queue<Integer> que = new LinkedList<>();
		que.offer(p1);
		visited[p1] = true;
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e=0; e<N; e++) {
				if(visited[e]) continue;
				if(e == p1) continue;
				if(family[s][e] == 0) continue;
				visited[e] = true;
				if(visited[p2]) {
					System.out.println(count);
					return;
				}
				que.offer(e);
			}
			count++;
		}
		System.out.println(-1);
	}
}
