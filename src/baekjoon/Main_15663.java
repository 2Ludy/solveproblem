package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15663 {
	
	static int N, M;
	static StringBuilder sb;
	static int[] p, nums, postP;
	static boolean[] visited;
	static Set<String> set;
	
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
		
		Arrays.sort(nums);
		p = new int[M];
		visited = new boolean[N];
		set = new HashSet<>();
		sb = new StringBuilder();
		
		nPr(0);
		
		String[] strs = set.toArray(new String[0]);
		Arrays.sort(strs);
		
		for(String s: strs) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	static void nPr(int cnt) {
		if(cnt == M) {
			String s = "";
			for(int num: p) {
				s += nums+" ";
			}
			set.add(s);
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
