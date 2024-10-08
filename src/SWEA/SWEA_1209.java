package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {
	
	static final int T = 10;
	static final int N = 100;
	static int testCase;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 0; t<T; t++) {
			testCase = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int max = 0;
			int hap = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 맵 생성
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					hap += map[i][j];
				}
				if(hap > max) {
					max = hap;
				}
				hap = 0;
			}
			
			for(int j=0; j<N; j++) {
				for(int i=0; i<N; i++) {
					hap += map[i][j];
				}
				if(hap > max) {
					max = hap;
				}
				hap = 0;
			}
			for(int i=0; i<N; i++) {
				hap += map[i][i];
			}
			if(hap > max) {
				max = hap;
			}
			hap = 0;
			for(int i=0; i<N; i++) {
				hap += map[i][N-i-1];
			}
			if(hap > max) {
				max = hap;
			}
			hap = 0;
			System.out.println("#" + testCase + " " +max);
 		}
	}
}
