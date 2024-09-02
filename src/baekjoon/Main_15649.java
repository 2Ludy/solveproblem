package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
	
	static int N, M;
	static StringBuilder sb;
	static int[] p;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		p = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		nPr(0);
		System.out.println(sb);
	}

	static void nPr(int cnt) {
		if(cnt == M) {
			for(int num : p) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[cnt] = i+1;
			nPr(cnt+1);
			p[cnt] = 0;
			visited[i] = false;
		}
	}

}