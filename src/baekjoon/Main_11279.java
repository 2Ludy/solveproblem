package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279 {
	
	static int N, num;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}
}