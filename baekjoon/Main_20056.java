package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056 {
	
	static int N, M, K;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<int[]> que; // r 좌표, c 좌표, m 질량, s 속력, d 방향
	static int[][] count;
	static List<int[]> tmp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		que = new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int[] nums = new int[5];
			for(int j=0; j<5; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			nums[0]--;
			nums[1]--;
			que.offer(nums);
		}
		
		while(K > 0) {
			count = new int[N][N];
			tmp = new ArrayList<>();
			while(!que.isEmpty()) {
				int[] nums = que.poll();
				int r = nums[0];
				int c = nums[1];
				int m = nums[2];
				int s = nums[3];
				int d = nums[4];
				r = r + dr[d]*s;
				if(r>=0) {
					r = r % N;
				}else {
					r = N - (Math.abs(r) % N);
					if(r == N) r = 0;
				}
				
				c = c + dc[d]*s;
				if(c>=0) {
					c = c % N;
				}else {
					c = N - (Math.abs(c) % N);
					if(c == N) c = 0;
				}
				
				count[r][c]++;
				tmp.add(new int[] {r, c, m, s, d});
			}
			
			boolean[] visited = new boolean[tmp.size()];
			for(int i=0; i<tmp.size(); i++) {
				if(visited[i]) continue;
				int[] nums = tmp.get(i);
				int r = nums[0];
				int c = nums[1];
				int m = nums[2];
				int s = nums[3];
				int d = nums[4];
				int newD = 0;
				visited[i] = true;
				
				if(count[r][c] == 1) {
					que.offer(nums);
				}else {
					for(int j=0; j<tmp.size(); j++) {
						if(visited[j]) continue;
						int[] newNums = tmp.get(j);
						int nr = newNums[0];
						int nc = newNums[1];
						int nm = newNums[2];
						int ns = newNums[3];
						int nd = newNums[4];
						if(nr != r || nc != c) continue;
						m += nm;
						s += ns;
						visited[j] = true;
						if(d%2 != nd%2) newD = 1;
					}
					if(m/5 == 0) continue;
					for(int k=0; k<=6; k=k+2) {
						que.offer(new int[] {r, c, m/5, s/count[r][c], k+newD});
					}
				}
			}
			K--;
		}
		if(que.size() == 0) {
			System.out.println(0);
		}else {
			int sum = 0;
			while(!que.isEmpty()) {
				sum += que.poll()[2];
				}
			System.out.println(sum);
		}
	}
}
