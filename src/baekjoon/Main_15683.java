package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {
	
	static int N, M, min;
	static int[][] map;
	static int count, size;
	static List<int[]> is5;
	static List<int[]> list;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		count = 0;
		is5 = new ArrayList<>();
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					count++;
				}else if(map[i][j] == 5) {
					is5.add(new int[] {i,j});
				}else if(map[i][j] != 6) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		if(is5.size() > 0) {
			for(int i=0; i<is5.size(); i++) {
				int[] nums = is5.get(i);
				int numr = nums[0];
				int numc = nums[1];
				direction1(numr,numc);
				direction2(numr,numc);
				direction3(numr,numc);
				direction4(numr,numc);
			}
		}
		
		size = list.size();
		p = new int[size];
		nCs(0,0);
	}

	private static void nCs(int idx, int cnt) {
		
		
	}

	private static void direction1(int r, int c) { // 오른쪽 방향
		for(int j=c+1; j<M; j++) {
			if(map[r][j] == 0) {
				map[r][j] = 7;
				count--;
			}else if(map[r][j] == 6) {
				return;
			}
		}
	}

	private static void direction2(int r, int c) { // 왼쪽 방향
		for(int j=c-1; j>=0; j--) {
			if(map[r][j] == 0) {
				map[r][j] = 7;
				count--;
			}else if(map[r][j] == 6) {
				return;
			}
		}
	}

	private static void direction3(int r, int c) { // 위쪽 방향
		for(int i=r-1; i>=0; i--) {
			if(map[i][c] == 0) {
				map[i][c] = 7;
				count--;
			}else if(map[i][c] == 6) {
				return;
			}
		}
	}

	private static void direction4(int r, int c) { // 아래쪽 방향
		for(int i=r+1; i<N; i++) {
			if(map[i][c] == 0) {
				map[i][c] = 7;
				count--;
			}else if(map[i][c] == 6) {
				return;
			}
		}
	}
}
