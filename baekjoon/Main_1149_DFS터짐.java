package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1149_DFS터짐 {
	
	static int N, min;
	static int[][] house;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		
		dfs(0,0,0);
		dfs(0,1,0);
		dfs(0,2,0);
		
		System.out.println(min);
	}

	static void dfs(int cnt, int idx, int hap) {
		if(hap>min) return;
		
		if(cnt == N) {
			min = Math.min(hap, min);
			return;
		}
		
		if(idx == 0) {
			dfs(cnt+1, 1, hap+house[cnt][idx]);
			dfs(cnt+1, 2, hap+house[cnt][idx]);
		}else if(idx == 1) {
			dfs(cnt+1, 0, hap+house[cnt][idx]);
			dfs(cnt+1, 2, hap+house[cnt][idx]);
		}else if(idx == 2){
			dfs(cnt+1, 0, hap+house[cnt][idx]);
			dfs(cnt+1, 1, hap+house[cnt][idx]);
		}
	}
}
