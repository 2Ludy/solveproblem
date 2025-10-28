package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {
	static class Edge {
		int e;
		int c;
		
		public Edge(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
	
	static int N, E;
	static int v1, v2;
	static List<Edge>[] list;
	static boolean[] visited;
	static int[] cost;
	static int max = 200000001;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[num1].add(new Edge(num2, cost));
			list[num2].add(new Edge(num1, cost));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int sum1 = 0;
		int sum2 = 0;
		
		sum1 += dijkstra(1, v1);
		sum1 += dijkstra(v1, v2);
		sum1 += dijkstra(v2, N);
		
		sum2 += dijkstra(1, v2);
		sum2 += dijkstra(v2, v1);
		sum2 += dijkstra(v1, N);
		
		sum1 = Math.min(sum1, sum2);
		if(sum1 >= max) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum1);
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});
		
		visited = new boolean[N+1];
		cost = new int[N+1];
		Arrays.fill(cost, max);
		cost[start] = 0;
		pq.offer(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visited[edge.e]) continue;
			visited[edge.e] = true;
			for(Edge next:list[edge.e]) {
				if(visited[next.e]) continue;
				if(edge.c + next.c < cost[next.e]) {
					cost[next.e]= edge.c + next.c;
					pq.offer(new Edge(next.e, cost[next.e]));
				}else {
					continue;
				}
			}
		}
		
		return cost[end];
	}
}
