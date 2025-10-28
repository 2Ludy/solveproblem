package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10760 {
	
	static int T, N, M, area, cnt;
	static int[][] map;
	static int[] or = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] oc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			} // 맵 생성 끝
			
			cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					area = 0;
					for(int k=0; k<8; k++) {
						int dr = r+or[k];
						int dc = c+oc[k];
						if(check(dr,dc,N,M) && map[r][c] - map[dr][dc] >0)
							area++;
					} // 8방 끝
					if(area >= 4)
						cnt++;
				}
			}
			System.out.println("#"+ t+ " "+ cnt);
		}
	}
	
	static boolean check(int r, int c,int N, int M) {
		return r>=0 && r<N && c>=0 && c<M; 
	}
}
