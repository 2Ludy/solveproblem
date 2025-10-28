package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {
	
	static int N, M, min;
	static int[][] map; // 0은 빈칸, 1은 집, 2는 치킨집
	static int[][] survive;
	static List<int[]> chick;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		chick = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chick.add(new int[] {i,j});
			}
		}
		
		survive = new int[M][2];
		min = Integer.MAX_VALUE;
		combi(0,0);
		System.out.println(min);
	}

	static void combi(int cnt, int idx) {
		if(cnt == M) {
			int sum = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 1) {
					int distance = Integer.MAX_VALUE;
					for(int i=0; i<M; i++) {
						int dis = Math.abs(r-survive[i][0]) + Math.abs(c-survive[i][1]);
						distance = Math.min(distance, dis);
						}
					sum += distance;
					if(sum >= min) return;
					}
				}
			}
			min = sum;
			return;
		}
		
		for(int i=idx; i<chick.size(); i++) {
			int[] nums = chick.get(i);
			survive[cnt][0] = nums[0];
			survive[cnt][1] = nums[1];
			combi(cnt+1, i+1);
		}
	}
}
