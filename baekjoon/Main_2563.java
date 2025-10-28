package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {
	
	static int[][] nums, square;
	static int N, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		square = new int[101][101];
		for(int i=0; i<N; i++) {
			for(int r=nums[i][0]; r<nums[i][0]+10; r++) {
				for(int c=nums[i][1]; c<nums[i][1]+10; c++) {
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
