package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1216 {
	
	static int T = 10;
	static int N = 100;
	static char[][] map;
	static int TC;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			TC = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			cnt=0;
			
			for(int M=1; M<N; M++) {
				for(int i=0; i< N; i++) {
					for(int j=0; j < N-M+1; j++) {
						boolean isS = true;
						for(int k=0; k<M/2; k++) {
							if(map[i][j+k] != map[i][j+M-1-k]) {
								isS = false;
								break;
							}
						}
						if(isS) cnt = M;
					}
				}
			}
				
			for(int M=1; M<N; M++) {
				for(int j=0; j< N; j++) {
					for(int i=0; i < N-M+1; i++) {
						boolean isS = true;
						for(int k=0; k<M/2; k++) {
							if(map[i+k][j] != map[i+M-1-k][j]) {
								isS = false;
								break;
							}
						}
						if(isS) cnt = Math.max(cnt,M);
					}
				}
			}
			System.out.println("#"+TC+" "+cnt);
		}
	}
}
