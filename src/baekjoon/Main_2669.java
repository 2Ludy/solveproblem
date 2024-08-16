package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669 {
	
	static int[][] nums, square;
	static int N = 4;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 nums = new int[N][N];
		 for(int i=0; i<N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int j=0; j<N; j++) {
				 nums[i][j] = Integer.parseInt(st.nextToken());
			 }
		 } // 좌표 받기
		 square = new int[101][101];
		 for(int i=0; i<N; i++) {
			 for(int r = nums[i][0]; r<nums[i][2]; r++) {
				 for(int c = nums[i][1]; c< nums[i][3]; c++) {
					 square[r][c] = 1;
				 }
			 }
		 }
		 count = 0;
		 for(int i=0; i<101; i++) {
			 for(int j=0; j<101; j++) {
				 if(square[i][j] == 1) count++;
			 }
		 }
		 System.out.println(count);
	}
}
