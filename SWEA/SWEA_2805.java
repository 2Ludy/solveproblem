package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2805 {
	
	static int T, N, hap;
	static char[] chars;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			hap = 0;
			
			for(int r=0; r<N; r++) {
				chars = br.readLine().toCharArray();
				for(int c=0; c<N; c++) {
					map[r][c] = chars[c]-'0';
				}
			} // 맵 생성
			for(int r=0; r<N; r++) {
				for(int c=Math.abs(N/2-r); c<=N-Math.abs(N/2-r)-1; c++) {
					hap += map[r][c];
				}
			}
			sb.append("#"+ t + " " + hap).append("\n");
		}
		System.out.println(sb);
	}
}
