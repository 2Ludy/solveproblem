package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
	
	static int N, M, min;
	static int[][] map;
	static int[] people;
	static boolean[] visited;
	static boolean[] dvisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken())-1;
				map[i][num] = 1;
			}
		}
		
		visited = new boolean[N];
		min = 100000000;
		subset(0);
		if(min == 100000000) min = -1;
		System.out.println(min);
	}

	static void subset(int cnt) {
		if(cnt == N) {
			int a=0;
			int b=0;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					a++;
				}else {
					b++;
				}
			}
			
			if(a==0 || b==0) return;
			
			int[] A = new int[a];
			int[] B = new int[b];
			int idx1 = 0;
			int idx2 = 0;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					A[idx1++] = i;
				}else {
					B[idx2++] = i;
				}
			}
			//유효성검사 통과못하면 return;
			if(!bfs(A,B)) return;
			
			int aPeople = 0;
			int bPeople = 0;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					aPeople += people[i];
				}else {
					bPeople += people[i];
				}
			}
			
			min = Math.min(min, Math.abs(aPeople - bPeople));
			return;
		}
		
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}

	static boolean bfs(int[] A, int[] B) {
		dvisited = new boolean[N];
		Queue<Integer> que = new LinkedList<>();
		que.offer(A[0]);
		dvisited[A[0]] = true;
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e=0; e<A.length; e++) {
				if(dvisited[A[e]]) continue;
				if(map[s][A[e]] == 1) {
					que.offer(A[e]);
					dvisited[A[e]] = true;
				}
			}
		}
		
		que.offer(B[0]);
		dvisited[B[0]] = true;
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int e=0; e<B.length; e++) {
				if(dvisited[B[e]]) continue;
				if(map[s][B[e]] == 1) {
					que.offer(B[e]);
					dvisited[B[e]] = true;
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(!dvisited[i]) return false;
		}
		
		return true;
	}
}