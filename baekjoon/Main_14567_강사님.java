package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567_강사님 {
	
	static int N, M;
	static int[] degree;
	static List<Integer>[] adj;
	static int[] time;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		time = new int[N+1];
		degree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			adj[out].add(in);
			degree[in]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<N+1; i++) {
			if(degree[i] == 0) {
				que.offer(i);
			}
		}
		int tt=1;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				int out = que.poll();
				
				for(int in : adj[out]) {
					degree[in]--;
					if(degree[in] == 0) que.offer(in);
				}
				
				time[out] = tt;
			}
			tt++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			sb.append(time[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
