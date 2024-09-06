package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
	
	static int[][] pan;
	static int[][] copyPan;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, count;
	static List<Integer> cheese;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pan = new int[R][C];
		cheese = new ArrayList<>();
		
		count = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j] == 1) count++;
			}
		}
		
		cheese.add(count);
		
		Queue<int[]> que = new LinkedList<>();
		copyPan = new int[R][C];
		for(int r=0; r<R; r++) {
			copyPan[r] = pan[r].clone();
		}
		
		while(count>0) {
			que.offer(new int[] {0,0});
			while(!que.isEmpty()) {
				int[] num = que.poll();
				for(int d=0; d<4; d++) {
					int sr = num[0] + dr[d];
					int sc = num[1] + dc[d];
					if(!check(sr,sc)) continue;
					if(pan[sr][sc] != 0) continue;
						pan[sr][sc] = 2;
					que.offer(new int[] {sr,sc});
				}
			}
			
			for(int i=1; i<R-1; i++) {
				for(int j=1; j<C-1; j++) {
					if(pan[i][j] == 1) {
						for(int d=0; d<4; d++) {
							int tr = i+dr[d];
							int tc = j+dc[d];
							if(pan[tr][tc] == 2) {
								copyPan[i][j] = 0;
								count--;
								break;
							}
						}
					}
				}
			}
			
			cheese.add(count);
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(copyPan[r][c] != 1) {
						pan[r][c] = 0;
					}else {
						pan[r][c] = 1;
					}
				}
			}
		}
		System.out.println(cheese.size()-1);
		System.out.println(cheese.get(cheese.size()-2));
	}

	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
