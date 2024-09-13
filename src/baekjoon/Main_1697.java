package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	
	static int N, K;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		visited = new boolean[150000];
		
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {N, 0});
		visited[N] = true;
		
		
		while(!que.isEmpty()) {
			int[] nums = que.poll();
			int cur = nums[0];
			int time = nums[1];
			dr[2] = cur;
			
			for(int d=0; d<3; d++) {
				int ncur = cur + dr[d];
				if(!check(ncur)) continue;
				if(visited[ncur]) continue;
				if(ncur== K) {
					System.out.println(time+1);
					return;
				}
				visited[ncur] = true;
				que.offer(new int[] {ncur, time+1});
			}
		}
	}

	static boolean check(int index) {
		return index>=0 && index<150000;
	}
}
