package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	static class Edge {
		int e;
		int c;
		public Edge(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
	
	static int N, M;
	static int start, end;
	static List<Edge>[] list;
	static int[] money;
	
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
			int cost = Integer.parseInt(st.nextToken());
			list[ss].add(new Edge(ee,cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		if(start == end) {
			System.out.println(0);
			return;
		}
		
		money = new int[N+1];
		Arrays.fill(money, 200000000);
		
		money[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});
		
		pq.offer(new Edge(start,0));
		
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visited[edge.e]) continue;
			visited[edge.e] = true;
			for(int i=0; i<list[edge.e].size(); i++) {
				Edge newE = list[edge.e].get(i);
				if(!visited[newE.e] && money[newE.e] > newE.c + money[edge.e]) {
					money[newE.e] = newE.c + money[edge.e];
					pq.offer(new Edge(newE.e, money[newE.e]));
				}
			}
		}
		System.out.println(money[end]);
	}
}
