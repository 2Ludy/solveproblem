package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16946 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'1';  // 1은 0으로, 0은 -1로 받으면 어떨까??
			}
		}
		int index = 2;
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == -1) {
					int count = 1;
					
					Queue<int[]> que = new LinkedList<>();
					map[i][j] = index;
					que.offer(new int[] {i,j});
					
					while(!que.isEmpty()) {
						int[] nums = que.poll();
						int r = nums[0];
						int c = nums[1];
						for(int d=0; d<4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(!check(nr,nc)) continue;
							if(map[nr][nc] != -1) continue;
							map[nr][nc] = index;
							que.offer(new int[] {nr,nc});
							count++;
						}
					}
					list.add(index,count);
					index++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					Set<Integer> set = new HashSet<>();
					int num = 1;
					for(int d=0; d<4; d++) {
						int r = i+dr[d];
						int c = j+dc[d];
						if(!check(r,c)) continue;
						set.add(map[r][c]);
					}
					for(int n : set) {
						num += list.get(n);
					}
					sb.append(num%10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}