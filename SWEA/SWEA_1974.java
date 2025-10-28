package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
	
	static int T, status, hap, kr, kc;
	static int N=9;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			map = new int[N][N];
			status = 1;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 맵생성
			
			for(int i=0; i<N; i++) {  
				hap = 0;
				for(int j=0; j<N; j++) { // 가로
					hap += map[i][j];
				}
				if(hap != 45) {
					status = 0;
					break;
				}
			}
			
			for(int j=0; j<N; j++) {
				hap = 0;
				for(int i=0; i<N; i++) {  // 세로
					hap += map[i][j];
				}
				if(hap != 45) {
					status = 0;
					break;
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					hap = map[3*i+1][3*j+1];
					for(int k=0; k<8; k++) {
						kr = 3*i+1+dr[k];
						kc = 3*j+1+dc[k];
						hap += map[kr][kc];
					}
					if(hap != 45) {
						status = 0;
						break;
					}
				}
				if(hap != 45) {
					status = 0;
					break;
			}
		}
			sb.append("#"+t+" "+status).append("\n");
		}
		System.out.println(sb);
	}
}
