package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767 {
	
	static int T, N;
	static int map[][];
	static int cores, maxcore, minline;
	static List<int[]> core;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i!=0 && i!=N-1 && j!=0 && j!= N-1) core.add(new int[] {i,j});
					}
				}
			}
			maxcore = 0;
			minline = 0;
			cores = core.size();
			work(0,0,0);
			System.out.println("#" + t + " " + minline);
		}
	}

	static void work(int idx, int coresu, int line) {
		if(idx == cores) {
			if(coresu > maxcore) {
				maxcore = coresu;
				minline = line;
			}else if(coresu == maxcore) {
				minline = Math.min(minline, line);
			}
			return;
		}
		
		int[] num = core.get(idx);
		int r = num[0];
		int c = num[1];
		
		// 왼쪽
		if(check1(r,c)) {
			for(int j=0; j<c; j++) {
				map[r][j] = 2;
			}
			work(idx+1,coresu+1,line+c);
			for(int j=0; j<c; j++) {
				map[r][j] = 0;
			}
		}
		// 오른쪽
		if(check2(r,c)) {
			for(int j=c+1; j<N; j++) {
				map[r][j] = 2;
			}
			work(idx+1,coresu+1,line+N-c-1);
			for(int j=c+1; j<N; j++) {
				map[r][j] = 0;
			}
		}
		// 아래
		if(check3(r,c)) {
			for(int i=r+1; i<N; i++) {
				map[i][c] = 2;
			}
			work(idx+1,coresu+1,line+N-r-1);
			for(int i=r+1; i<N; i++) {
				map[i][c] = 0;
			}
		}
		// 위
		if(check4(r,c)) {
			for(int i=0; i<r; i++) {
				map[i][c] = 2;
			}
			work(idx+1,coresu+1,line+r);
			for(int i=0; i<r; i++) {
				map[i][c] = 0;
			}
		}
		// 프로세스 제외
		work(idx+1,coresu,line);
	}

	private static boolean check4(int r, int c) { // 위
		for(int i=0; i<r; i++) {
			if(map[i][c] != 0) return false;
		}
		return true;
	}

	private static boolean check3(int r, int c) { // 아래
		for(int i=r+1; i<N; i++) {
			if(map[i][c] != 0) return false;
		}
		return true;
	}

	private static boolean check2(int r, int c) { // 오른쪽
		for(int j=c+1; j<N; j++) {
			if(map[r][j] != 0) return false;
		}
		return true;
	}

	private static boolean check1(int r, int c) { // 왼쪽
		for(int j=0; j<c; j++) {
			if(map[r][j] != 0) return false;
		}
		return true;
	}
}
