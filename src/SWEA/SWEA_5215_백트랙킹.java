package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_백트랙킹 {
	
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
		if(cal > L) {
			return;
		}
		
		if(cnt == N) {
			if(max < score)
				max = score;
			return;
		}
		nCr(cnt+1, score+burger[cnt][0], cal+burger[cnt][1]);
		nCr(cnt+1,score,cal);
	}
}
