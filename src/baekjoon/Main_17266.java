package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17266 {
	
	static int N, M;
	static Queue<Integer> que;
	static int max;
	static int prev;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		que = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		que.offer(N);

		max = 0;
		prev = que.poll();
		max = Math.max(max, prev);

		while(!que.isEmpty()) {
			int next = que.poll();
			if(que.isEmpty()) {
				max = Math.max(max, next-prev);
			}
			max = Math.max(max, (next-prev+1)/2);
			prev = next;
		}
		System.out.println(max);
	}
}