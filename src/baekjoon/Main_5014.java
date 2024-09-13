package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5014 { 
	
	static int F, S, G, U, D;
	static boolean[] visited;
	static int min, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken())-1;
		G = Integer.parseInt(st.nextToken())-1;
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		visited = new boolean[F];
		count = 0;
		
		if(U!= 0 && S<G) {
			count = (G-S)/U;
			S += count*U;
		}else if (D!=0 && S>G) {
			count = (S-G)/D;
			S = S-count*D;
		}
		
		bfs(S,count);
		if(min == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
			return;
		}
		System.out.println(min);
	}

	static void bfs(int cur, int cnt) {
		if(visited[cur]) return;
		visited[cur] = true;
		if(cur == G) {
			min = Math.min(cnt, min);
			return;
		}
		
		if(check(cur+U) && cur < G+D) {
			bfs(cur+U, cnt+1);
		}
		
		if(check(cur-D) && cur > G-U) {
			bfs(cur-D, cnt+1);
		}
	}





	static boolean check(int idx) {
		return idx>=0 && idx<F;
	}
}
