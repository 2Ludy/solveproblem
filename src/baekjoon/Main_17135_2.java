package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17135_2 {
	
	static int N, M, D;
	static List<Integer>[] dis; // 궁수로부터 모든 적들의 거리를 나타내는....
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<Integer> rIndex;
	static List<Integer> cIndex;
	static boolean[] visited;
	static int[] p;
	static int count, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		p = new int[3];
		dis = new ArrayList[M];
		rIndex = new ArrayList<>();
		cIndex = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			dis[i] = new ArrayList<>();
		}
		 
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					rIndex.add(r);
					cIndex.add(c);
					count++; 
					for(int k=0; k<M; k++) {
						int distance = N-r + Math.abs(c-k);
						dis[k].add(distance);
					}
				}
			}
		} // 입력 끝
		// count가 곧 사이즈 list 배열 하나하나의 크기는 모두 count로 동일 index로 관리하면 될듯?
		visited = new boolean[count];
		max = 0;
		mC3(0,0);
		
		System.out.println(max);
	}

	private static void mC3(int idx, int cnt) {
		if(cnt == 3) {
			game();
			return;
		}
		for(int j=idx; j<M; j++) {
			p[cnt] = j;
			mC3(j+1, cnt+1);
		}
	}

	private static void game() {
		 int time = 0;
		 int kill = 0;
		 int enemy = count;
		 while(enemy > 0) {
			 Set<Integer> set = new HashSet<>();
			 int[] nums0 = {D+1,20, -1}; // 거리 , r 좌표, index로 가자
			 int[] nums1 = {D+1,20, -1};
			 int[] nums2 = {D+1,20, -1};
			 
			 for(int i=0; i<count; i++) {
				if(visited[i]) continue;
				if(nums0[0] > dis[p[0]].get(i)) {
					nums0[0] = dis[p[0]].get(i);
					nums0[1] = cIndex.get(i);
					nums0[2] = i;
				}else if(nums0[0] == dis[p[0]].get(i)) {
					if(nums0[1] > cIndex.get(i)) {
						nums0[1] = cIndex.get(i);
						nums0[2] = i;
					}
				}
				
				if(nums1[0] > dis[p[1]].get(i)) {
					nums1[0] = dis[p[1]].get(i);
					nums1[1] = cIndex.get(i);
					nums1[2] = i;
				}else if(nums1[0] == dis[p[1]].get(i)) {
					if(nums1[1] > cIndex.get(i)) {
						nums1[1] = cIndex.get(i);
						nums1[2] = i;
					}
				}
				
				if(nums2[0] > dis[p[2]].get(i)) {
					nums2[0] = dis[p[2]].get(i);
					nums2[1] = cIndex.get(i);
					nums2[2] = i;
				}else if(nums2[0] == dis[p[2]].get(i)) {
					if(nums2[1] > cIndex.get(i)) {
						nums2[1] = cIndex.get(i);
						nums2[2] = i;
					}
				}
			 }
			 if(nums0[2] != -1) {
				 set.add(nums0[2]);
			 }
			 if(nums1[2] != -1) {
				 set.add(nums1[2]);
			 }
			 if(nums2[2] != -1) {
				 set.add(nums2[2]);
			 }
			 
			 for(int num : set) {
				 kill++;
				 enemy--;
				 visited[num] = true;
			 }
			 time++;
			 for(int i=0; i<count; i++) {
				 if(rIndex.get(i) == N-time) {
					 visited[i] = true;
					 enemy--;
				 }
			 }
			
		 }
		 max = Math.max(kill, max);
	}
}