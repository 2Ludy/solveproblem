package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	
	static int T, N, M, hap, max;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			hap = 0;
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<M; j++) {
					hap += map[i][j];  // 최초합
				}
			}
			max = hap;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=1; j<=N-M; j++) {
					for(int k=0; k<M; k++) {
						hap = hap - map[i+k][j-1]+map[i+k][j+M-1];
					}
					max = Math.max(max, hap);
				}
				hap = 0;
				if(i+M<N) {
					for(int r=i+1; r<i+M+1; r++) {
						for(int c=0; c<M; c++) {
							hap += map[r][c];
						}
					}
					Math.max(max, hap);
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
