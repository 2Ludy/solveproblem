package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567 {
	
	static int N, M;
	static List<Integer>[] list;
	static List<int[]> ans;
	static boolean[] visited;
	static int time;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			list[Integer.parseInt(st.nextToken())-1].add(num);
		}
		
		que = new LinkedList<>();
		visited = new boolean[N];
		time = 1;
		StringBuilder sb = new StringBuilder();
		ans = new ArrayList<>();
		
		a : while(true) {
			for(int i=0; i<N; i++) {
				if(!visited[i] && list[i].size() == 0) que.offer(i);
			}
			if(que.isEmpty()) break a;
			while(!que.isEmpty()) {
				int num = que.poll();
				for(int i=0; i<N; i++) {
					for(int j=0; j<list[i].size(); j++) {
						if(list[i].get(j) == num) list[i].remove(j);
					}
				}
				
				visited[num] = true;
				ans.add(new int[] {num+1, time});
			}
			time++;
		}
		
		Collections.sort(ans, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<ans.size(); i++) {
			int[] nums = ans.get(i);
			sb.append(nums[1]).append(" ");
		}
		
		System.out.println(sb);
	}
}
