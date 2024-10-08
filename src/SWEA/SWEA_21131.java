package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_21131 {
	
	static int T, N, count, r, tmp;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 맵생성
			r = N-1;
			count = 0;
			while(r>=0) {
				for(int c=0; c<=r; c++) {
					if(map[r][c] != r*N+c+1) {
						count++;
						for(int i=0; i<=r; i++) {
							for(int j=i+1; j<=r; j++) {
								tmp = map[i][j];
								map[i][j] = map[j][i];
								map[j][i] = tmp;
							}
						}
					}
				}
				r--;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
