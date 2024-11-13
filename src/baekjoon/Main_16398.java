package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16398 {
	static class Edge implements Comparable<Edge>{
		int point;
		long weight;
		
		public Edge(int point, long weight) {
			super();
			this.point = point;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	
	static int N;
	static List<Edge>[] list;
	static boolean[] visited;
	static final long max = 1000000000001L;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0);
			return;
		}
		list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				list[i].add(new Edge(j,num));
			}
		}
		
		visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0));
		
		long sum = 0L;
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			if(visited[current.point]) continue;
			visited[current.point] = true;
			sum += current.weight;
			if(N-- == 0) break;
			
			for(Edge next: list[current.point]) {
				if(visited[next.point]) continue;
				pq.offer(next);
			}
		}
		
		System.out.println(sum);
	}
}
