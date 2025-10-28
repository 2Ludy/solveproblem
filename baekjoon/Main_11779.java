package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779 { 
	static class Edge implements Comparable<Edge>{
		int end;
		int cost;
		
		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M;
	static List<Edge>[] list;
	static boolean[] visited;
	static PriorityQueue<Edge> pq;
	static int[] minCost;
	static int[] parent;
	static final int INF = 100000001;
	static int startBus, endBus;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ss = Integer.parseInt(st.nextToken());
			int ee = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			list[ss].add(new Edge(ee,cc));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		startBus = Integer.parseInt(st.nextToken());
		endBus = Integer.parseInt(st.nextToken());
		
		if(startBus == endBus) {
			System.out.println(0);
			System.out.println(2);
			System.out.println(startBus + " " + endBus);
			return;
		}
		
		visited = new boolean[N+1];
		pq = new PriorityQueue<>();
		
		minCost = new int[N+1];
		Arrays.fill(minCost, INF);
		
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		minCost[startBus] = 0;
		pq.offer(new Edge(startBus, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			int curE = curr.end;
			int curC = curr.cost;
			if(visited[curE]) continue;
			visited[curE] = true;
			
			for(Edge next: list[curE]) {
				int nextE = next.end;
				int nextC = next.cost;
				if(visited[nextE]) continue;
				if(minCost[nextE] > curC+nextC) {
					minCost[nextE] = curC+nextC;
					parent[nextE] = curE;
					pq.offer(new Edge(nextE, minCost[nextE]));
				}
			}
		}
		List<Integer> path = new ArrayList<>();
		int current = endBus;
		
		while(current != -1) {
			path.add(current);
			current = parent[current];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(minCost[endBus]).append("\n");
		sb.append(path.size()).append("\n");
		for(int i=path.size()-1; i>=0; i--) {
			int n = path.get(i);
			sb.append(n).append(" ");
		}
		System.out.print(sb);
	}
}
