package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {

	static int[] nums, answer;
	static boolean[] visited;
	static StringBuilder sb;
	static int k;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) return;
			nums = new int[k];
			answer = new int[6];
			visited = new boolean[k];
			
			for(int i=0; i<k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			nCr(0,0);
			System.out.print(sb);
			System.out.println();
		}
	}

	private static void nCr(int idx, int cnt) {
		if(cnt == 6) {
			for(int num : answer) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<k; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			answer[cnt] = nums[i];
			nCr(i+1, cnt+1);
			visited[i] = false;
		}
	}
}
