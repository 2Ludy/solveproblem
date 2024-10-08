package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1494 {
	
	static int T, N;
	static int M;
	static int[][] list;
	static boolean[] visited;
	static long result ,min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = N/2;
			
			list = new int[N][2];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N];
			min = Long.MAX_VALUE;
			
			nCr(0,0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			System.out.println(sb);
		}
	}

	static void nCr(int index, int cnt) {
		if(index == M) {
			long x = 0;
			long y = 0;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					x += list[i][0];
					y += list[i][1];
				}else {
					x -= list[i][0];
					y -= list[i][1];
				}
			}
			result = (long)x*x + (long)y*y;
			min = Math.min(result, min);
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			visited[i] = true;
			nCr(index+1, i+1);
			visited[i] = false;
		}
		
	}
}
