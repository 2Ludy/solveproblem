package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_7465 {
	
	static int T, N, M; // N = 정점의 개수, M = 간선의 개수
	static int count;
	static int[] p,r;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];  // 0번 버려
			r = new int[N+1];  // 0번 버려
			for(int i=1; i<N+1; i++) {
				p[i] = i;
				r[i] = 1;
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				int x = find(s);
				int y = find(e);
				
				union(x,y);
			}
			count = 0;
			for(int i=1; i<N+1; i++) {
				if(p[i] == i) count++;
			}
			System.out.println("#" + t + " " + count);
		}
	}

	static void union(int x, int y) {
		if(x == y) return;
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = p[y];
		}else {
			r[x] += r[y];
			p[y] = p[x];
		}
		
	}

	static int find(int x) {
		if(x != p[x]) p[x] = find(p[x]);
		return p[x];
	}
}
