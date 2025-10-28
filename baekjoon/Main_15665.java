package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15665 {
	
	static int N, M, idx;
	static StringBuilder sb;
	static int[] p, nums;
	static boolean[] visited;
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		idx = 0;
		
		Arrays.sort(nums);
		p = new int[M];
		visited = new boolean[N];
		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				for(int i=0; i<M; i++) {
					if(o1[i] == o2[i])continue;
					return o1[i]-o2[i];
				}
				return 0;
			}
		});
		sb = new StringBuilder();
		
		nCr(0);
		
		int[] past = new int[M];
		while(!pq.isEmpty()) {
			int[] nums = pq.poll();
			if(!Arrays.equals(past, nums)) {
				for(int num : nums) {
					sb.append(num).append(" ");
				}
				sb.append("\n");
				past = nums;
			}
		}
		
		System.out.print(sb);
	}

	static void nCr(int cnt) {
		if(cnt == M) {
			pq.offer(p.clone());
			return;
		}
		
		for(int i=0; i<N; i++) {
			p[cnt] = nums[i];
			nCr(cnt+1);
		}
	}
}
