package baekjoon;

import java.util.Scanner;

public class Main_2447 { 
	
	static int[][] star;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		star = new int[N][N];
		star(0,0,N);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]==1?"*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void star(int r, int c, int n) {
		if(n==3) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == 1 && j == 1) continue; // 중앙만 제외
					star[r+i][c+j]=1;
				}
			}
		}else {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == 1 && j == 1) continue; // 중앙만 제외
					star(r+i*n/3,c+j*n/3,n/3);
				}
			}
		}
	}
}
