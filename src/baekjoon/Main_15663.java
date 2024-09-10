package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15663 {
	
	static int N, M, idx;
	static StringBuilder sb;
	static int[] p, nums, postP;
	static boolean[] visited;
	
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
		sb = new StringBuilder();
		
		nPr(0);
		
		System.out.println(sb);
	}

	static void nPr(int cnt) {
		if(cnt == M) {
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[cnt] = nums[i];
			nPr(cnt+1);
			p[cnt] = 0;
			visited[i] = false;
		}
	}
}
