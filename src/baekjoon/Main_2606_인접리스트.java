package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_인접리스트 { 
	
	static int V, E, count;
	static List<Integer>[] edges;
	static boolean[] visited;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[V];
		for(int i=0; i<V; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int k=0; k<E; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			edges[num1].add(num2);
			edges[num2].add(num1);
			
			
		} // 맵 생성
		
		visited = new boolean[V];
		count = 0;
		que = new LinkedList<>();
		que.offer(0);
		visited[0] = true;
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e : edges[s]) {
				if(visited[e]) continue;
				que.offer(e);
				visited[e] = true;
				count++;
			}
		}
		System.out.println(count);
	}
}
