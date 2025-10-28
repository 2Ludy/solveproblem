package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251 {
	
	static int T, N;
	static int[][] map;
	static double E;
	static class Edge implements Comparable<Edge> {
		
		int v;
		long w;

		public Edge(int v, long w) {
			super();
			this.v = v;
			this.w = w;
		}


		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
		
	}
	
	static List<Edge>[] edges;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			edges = new ArrayList[N];
			
			for(int i=0; i<N; i++) {
				edges[i] = new ArrayList<>();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long dis = distance(map[i][0],map[i][1],map[j][0],map[j][1]);
					edges[i].add(new Edge(j,dis));
					edges[j].add(new Edge(i,dis));
				}
			}
			long result = prim();
			System.out.println("#" + t + " " + Math.round(E*result));
		}
	}

	static long prim() {
		visited = new boolean[N];
		long min = 0L;
		long cnt = 0;
		PriorityQueue<Edge> points = new PriorityQueue<>();
		points.offer(new Edge(0, 0L));
		
		while(!points.isEmpty()) {
			Edge cur = points.poll();
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			min += cur.w;
			if(++cnt == N) return min;
			
			for(Edge next : edges[cur.v]) {
				if(visited[next.v]) continue;
				points.offer(next);
			}
		}
		return min;
	}

	private static long distance(int x1, int y1, int x2, int y2) {
		return (0L+x1-x2)*(0L+x1-x2)+(0L+y1-y2)*(0L+y1-y2);
	}
}
