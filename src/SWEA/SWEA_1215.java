package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1215 {
	
	static int T = 10;
	static int N = 8;
	static char[][] map;
	static int M;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			M = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			cnt=0;
			
			for(int i=0; i< N; i++) {
				for(int j=0; j < N-M+1; j++) {
					boolean isS = true;
					for(int k=0; k<M/2; k++) {
						if(map[i][j+k] != map[i][j+M-1-k]) {
							isS = false;
							break;
						}
					}
					if(isS) cnt++;
				}
			}
			
			for(int j=0; j< N; j++) {
				for(int i=0; i < N-M+1; i++) {
					boolean isS = true;
					for(int k=0; k<M/2; k++) {
						if(map[i+k][j] != map[i+M-1-k][j]) {
							isS = false;
							break;
						}
					}
					if(isS) cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}
	
}
