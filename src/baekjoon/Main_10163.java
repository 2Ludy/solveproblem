package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163 {
	
	static int N, count;
	static int[][] nums;
	static int[][] maps;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N][4];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			} 
		} // 생성
		
		maps = new int[1001][1001];
		for(int i=0; i<N; i++) {
			for(int r=nums[i][0]; r<= nums[i][2] + nums[i][0]-1; r++) {
				for(int c=nums[i][1]; c<= nums[i][3] + nums[i][1]-1; c++) {
					maps[r][c] = i+1;
				}
			} 
		} // 색종이 생성
		
		for(int i=0; i<N; i++) {
			count = 0;
			for(int r=0; r<1001; r++) {
				for(int c=0; c<1001; c++) {
					if(maps[r][c] == i+1) count ++;
				}
			}
			System.out.println(count);
		}
	}
}
