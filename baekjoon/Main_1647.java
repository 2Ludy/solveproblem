package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647 {
	static class Edge implements Comparable<Edge>{
		int point;
		int weight;
		
		public Edge(int point, int weight) {
			this.point = point;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M;
	static List<Edge>[] list;
	static final int max = 100000001;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int ss = Integer.parseInt(st.nextToken());
			int ee = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			list[ss].add(new Edge(ee,cc));
			list[ee].add(new Edge(ss,cc));
		}
		
		visited = new boolean[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1,0));
		
		int maxCost = 0;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			if(visited[current.point]) continue;
			visited[current.point] = true;
			sum += current.weight;
			maxCost = Math.max(maxCost, current.weight);
			if(N-- == 0) break;
			
			for(Edge next:list[current.point]) {
				if(visited[next.point]) continue;
				pq.offer(next);
			}
		}
		System.out.println(sum - maxCost);
		
	}
}
