package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1197 {
	
	static int V, E;
	static int pick, sum;
	static int[] P, R;
	static PriorityQueue<int[]> que;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}});
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			que.offer(new int[] {s,e,w});
		}
		
		pick = 0;
		sum = 0;
		
		P = new int[V+1];
		for(int i=0; i<V+1; i++) {
			P[i] = i;
		}
		
		R = new int[V+1];
		Arrays.fill(R, 1);
		
		while(!que.isEmpty()) {
			int[] pol = que.poll();
			int s = pol[0];
			int e = pol[1];
			int w = pol[2];
			
			union(s,e,w);
			if(pick == V-1) break;
		}
		
		System.out.println(sum);
	}

	static void union(int s, int e, int w) {
		int fs = find(s);
		int fe = find(e);
		if(fs == fe) return;
		
		if(R[fs] < R[fe]) {
			R[fe] += R[fs];
			P[fs] = fe;
		}else {
			R[fs] += R[fe];
			P[fe] = fs;
		}
		pick++;
		sum += w;
		
	}

	static int find(int s) {
		if(s != P[s]) P[s] = find(P[s]);
		return P[s];
	}
}
