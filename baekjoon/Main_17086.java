package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17086 {
	
	static int N, M;
	static int max;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		List<int[]> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					int distance = Integer.MAX_VALUE;
					for(int k=0; k<list.size(); k++) {
						int[] nums = list.get(k);
						int r = nums[0];
						int c = nums[1];
						int d = Math.max(Math.abs(i-r),Math.abs(j-c));
						distance = Math.min(distance, d);
					}
					max = Math.max(max, distance);
				}
			}
		}
		System.out.println(max);
	}
}