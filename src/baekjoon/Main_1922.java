package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922 {
	static class Edge{
		int end;
		int cost;
		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int N, M;
	static List<Edge>[] list;
	static boolean[] visited;
	static int cost;
	static int connected;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		visited = new boolean[N+1];
		connected = N;
		cost = 0;
		pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.cost - o2.cost;
			}
			
		});

		for(int i=0; i<list[1].size(); i++) {
			pq.offer(list[1].get(i));
		}
		
		visited[1] = true;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visited[edge.end]) continue;
			cost += edge.cost;
			N--;
			if(N==0 || N==1) {
				System.out.println(cost);
				return;
			}
			visited[edge.end] = true;
			for(int i=0; i<list[edge.end].size(); i++) {
				pq.offer(list[edge.end].get(i));
			}
		}
	}
}
