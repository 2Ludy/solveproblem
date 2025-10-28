package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	
	/*
	 * 흠.. .아이디어를 어떻게 짜야하지 흠...
	 * 일단 가져가야 할 정보는 r 좌표, c 좌표, distance, 아기 상어 크기 size 
	 * Priorityque로 만들어서 distance관리해서 distance 짧은순으로 나오도록 하고
	 * 만약 먹을 수 있는 물고기가 나오는 순간 거기로 이동하는게 맞을듯?
	 * 그리고 bfs 파괴하는거지
	 * 만약 bfs가 굶어 죽는다면? 엄마 도움 받아야하니까 끝//
	 * 모든 아기상어의 수 count 해서 이걸로 while문으로 끝까지 돌리면 될듯??
	 * 최종 distance가 결국 time
	 */
	
	static int N;
	static int[][] map; 
	static int[] dr = {-1, 0, 0, 1};  //0 = 위, 1 = 왼쪽, 2 = 오른쪽, 3 = 아래
	static int[] dc = {0, -1, 1, 0}; 
	static boolean[][][] visited; // r 좌표, c 좌표, size 로 boolean 배열 만들어서 방문 체크 해야 할듯
	static int count; // 0과 9가 아닌 숫자(다른상어)들이 몇개인지 판별?
	static int dis;
	static int sr, sc; // 시작지점
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sr = i;
					sc = j;
					map[sr][sc] = 0;
				}
				if(map[i][j] >0 && map[i][j]<9) count++;
			}
		}
		dis = 0;
		Queue<int[]> que = new LinkedList<>();
		
		visited = new boolean[N][N][count+1];
		que.offer(new int[] {sr, sc, 0, 2, 0});
		visited[sr][sc][count] = true;
		
		while(!que.isEmpty()) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[2] == o2[2]) {
						if(o1[0] == o2[0]) return o1[1] - o2[1];
						return o1[0]-o2[0];
					}
					return o1[2]-o2[2];
				}
				
			});
			
			int queSize = que.size();
			if(count == 0) {
				System.out.println(dis);
				return;
			}
			
			for(int i=0; i<queSize; i++) {
				
				int[] nums = que.poll();
				int r = nums[0];
				int c = nums[1];
				int distance = nums[2];
				int size = nums[3];
				int eat = nums[4];
				
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc] > size) continue;
					if(visited[nr][nc][count]) continue;
					
					if(map[nr][nc] == size || map[nr][nc] == 0) {
						que.offer(new int[] {nr, nc, distance+1, size, eat});
						visited[nr][nc][count] = true;
						
					}else{
						pq.offer(new int[] {nr, nc, distance, size, eat});
					}
				}
			}
			if(pq.size() > 0) {
				int[] pqnums = pq.poll();
				int pqr = pqnums[0];
				int pqc = pqnums[1];
				int pqdistance = pqnums[2];
				int pqsize = pqnums[3];
				int pqeat = pqnums[4];
				
				int newEat = pqeat+1;
				
				if(newEat == pqsize) {
					count--;
					dis = pqdistance+1;
					
					map[pqr][pqc] = 0;
					que.clear();
					que.offer(new int[] {pqr, pqc, pqdistance+1, pqsize+1, 0});
					visited[pqr][pqc][count] = true;
				}else {
					count--;
					dis = pqdistance+1;
					
					map[pqr][pqc] = 0;
					que.clear();
					que.offer(new int[] {pqr, pqc, pqdistance+1, pqsize, newEat});
					visited[pqr][pqc][count] = true;
				}
			}
		}
		System.out.println(dis);
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
