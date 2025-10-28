package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775 {
	
	static int T, k, n;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			map = new int[k+1][n];
			
			for(int j=0; j<n; j++) {
				map[0][j] = j+1;
			}
			
			for(int i=1; i<=k; i++) {
				for(int j=0; j<n; j++) {
					for(int jj=0; jj<=j; jj++) {
						map[i][j] += map[i-1][jj];
					}
				}
			}
			sb.append(map[k][n-1]).append("\n");
		}
		System.out.println(sb);
	}
}
