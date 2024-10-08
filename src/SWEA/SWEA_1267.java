package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1267 {
	
	static int T = 10;
	static int V, E;
	static List<Integer>[] adj;
	static List<Integer> ans;
	static int[] degree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			ans = new ArrayList<>();
			degree = new int[V+1];
			adj = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				adj[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int in = Integer.parseInt(st.nextToken());
				int out = Integer.parseInt(st.nextToken());
				adj[in].add(out);
				degree[out]++;
			}
			
			Queue<Integer> que = new LinkedList<>();
			
			for(int i=1; i<V+1; i++) {
				if(degree[i] == 0) que.offer(i);
			}
			
			while(!que.isEmpty()) {
				int num = que.poll();
				for(int i : adj[num]) {
					degree[i]--;
					if(degree[i] == 0) que.offer(i);
				}
				ans.add(num);
			}
			StringBuilder sb = new StringBuilder();
			for(int n : ans) sb.append(n).append(" ");
			System.out.println("#" + t + " " + sb);
		}
	}
}
