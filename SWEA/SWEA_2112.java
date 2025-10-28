package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112 {
	
	static int T, D, W, K, min;
	static int[] visited; //0일때 0채우기 1일때 1채우기 2일때 그대롱
	static int[][] flim;
	static int[][] flim2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			flim = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					flim[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			flim2 = new int[D][W];
			visited = new int[D];
			min = 10000000;
			logic(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	static void logic(int cnt, int visit) {
		if(visit >= min) return;
		
		if(cnt == D) {
			for(int i=0; i<D; i++) {
				if(visited[i] == 2) {
					for(int j=0; j<W; j++) {
						flim2[i][j] = flim[i][j];
					}
				}else if(visited[i] == 1) {
					for(int j=0; j<W; j++) {
						flim2[i][j] = 1;
					}
				}else {
					for(int j=0; j<W; j++) {
						flim2[i][j] = 0;
					}
				}
			}
			
			if(logic2(flim2)) {
				min = Math.min(min, visit);
			}
			 return;
		}
		
		visited[cnt] = 2;
		logic(cnt+1, visit);
		
		visited[cnt] = 1;
		logic(cnt+1, visit+1);
		
		visited[cnt] = 0;
		logic(cnt+1, visit+1);
		
	}

	static boolean logic2(int[][] map) {
		a : for(int j=0; j<W; j++) {
			int num0 = 0;
			int num1 = 0;
			
			for(int i=0; i<D; i++) {
				if(map[i][j] == 0) {
					num0++;
					num1 = 0;
				}else {
					num0 = 0;
					num1++;
				}
				if(num0 == K || num1 == K) continue a;
			}
			return false;
		}
		return true;
	}
}
