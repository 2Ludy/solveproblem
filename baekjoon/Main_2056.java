package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_2056 {
	
	static int N, max;
	static int[] degrees;
	static int[] times;
	static int[] anstimes;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		degrees = new int[N+1];
		times = new int[N+1];
		anstimes = new int[N+1];
		adj = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			times[i] = num;
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int out = Integer.parseInt(st.nextToken());
				adj[i].add(out);
				degrees[out]++;
			}
		} // input 완
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(degrees[i] == 0) {
				que.offer(i);
				anstimes[i] = times[i];
			}
		} // que에 삽입 완
		
		while(!que.isEmpty()) {
			int num = que.poll();
			for(int in: adj[num]) {
				anstimes[in] = Math.max(anstimes[in], anstimes[num]+times[in]);
				degrees[in]--;
				if(degrees[in] == 0) que.offer(in);
			}
		}
		max = 0;
		for(int num : anstimes) max = Math.max(max, num);
		System.out.println(max);
	}
}
