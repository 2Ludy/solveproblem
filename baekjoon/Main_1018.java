package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018 {
	
	static int N, M, c, min, count1, count2;
	static char[][] chars;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chars = new char[N][M];
		
		for(int i=0; i<N; i++) {
			chars[i] = br.readLine().toCharArray();
		}
		min = 2000000000;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				count1 = 0;
				count2 = 0;
				
				for(int r=0; r<8; r++) {
					for(int c=0; c<8; c++) {

						if(r%2 == 0) {
							if(c%2 == 0) {
								if(chars[i+r][j+c] != 'W') {
									count1++;
								}else {
									count2++;
								}
							}else {
								if(chars[i+r][j+c] != 'B') {
									count1++;
								}else {
									count2++;
								}
							}
						}else {
							if(c%2 == 0) {
								if(chars[i+r][j+c] != 'B') {
									count1++;
								}else {
									count2++;
								}
							}else {
								if(chars[i+r][j+c] != 'W') {
									count1++;	
								}else {
									count2++;
								}
							}
						}
					}
				}
				min = Math.min(min, Math.min(count1, count2));
			}
		}
		System.out.println(min);
	}
}
