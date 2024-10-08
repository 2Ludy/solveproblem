package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {
	
	static int T;
	static int N;
	static int[][] snail;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			int nums = 1;
			int r = 0;
			int c = N-1;
			for(int j=0; j<N; j++) {
				snail[r][j] = nums++;
			}
			int direction = 0; // 아래 0 왼쪽 1 위 2 오른 3 아래 
			while(nums <= N*N) {
				if(direction == 0) {
					if(r+1 <N && snail[r+1][c] == 0) {
						snail[++r][c] = nums++;
					}else {
						direction = 1;
					}
				}else if(direction == 1) {
					if(c-1 >=0 && snail[r][c-1] == 0) {
						snail[r][--c] = nums++;
					}else {
						direction = 2;
					}
				}else if(direction == 2) {
					if(r-1 >=0 && snail[r-1][c] == 0) {
						snail[--r][c] = nums++;
					}else {
						direction = 3;
					}
				}else {
					if(c+1<N && snail[r][c+1] == 0) {
						snail[r][++c] = nums++;
					}else {
						direction = 0;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+"\n");
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					sb.append(snail[a][b]+" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}
