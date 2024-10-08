package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	
	static int T, N, L, max;
	static int[][] burger;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			burger = new int[N][2]; // 0열 맛 점수, 1열 칼로리
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				burger[i][0] = Integer.parseInt(st.nextToken());
				burger[i][1] = Integer.parseInt(st.nextToken());
			} // 점수, 칼로리 생성
			
			max = 0;
			nCr(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}
	}

	static void nCr(int cnt, int score, int cal) {
		if(cal > L) return; // 칼로리가 L을 초과하거나 cnt가 N을 초과하면 탈출
		
		max = Math.max(max, score);
		
		if(cnt == N) return; // cnt 가 N이라면 위의 max 갱신 후 탈출
		
		for(int i=cnt; i<N; i++) {
			nCr(i+1, score+burger[i][0], cal+burger[i][1]);
		}
	}
}
