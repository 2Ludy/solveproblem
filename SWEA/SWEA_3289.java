package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	
	static int T;
	static int n,m;
	static int[] p;
	static int[] rank;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			p = new int[n+1];
			for(int i=1; i<n+1; i++) {
				p[i] = i;
			}
			rank = new int[n+1];
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int in = Integer.parseInt(st.nextToken());
				int out = Integer.parseInt(st.nextToken());
				if(num == 0) {
					union(in, out);
				}else {
					if(find(in) == find(out)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
		}
	}


	static int find(int x) {
		if(p[x] == x) return x;
		return find(p[x]);
	}


	static void union(int in, int out) {
		int x = find(in);
		int y = find(out);
		
		if(x == y) return;
		
		if(rank[x] >= rank[y]) {
			rank[x] += rank[y];
			p[y] = p[x];
		}else {
			rank[y] += rank[x];
			p[x] = p[y];
		}
	}
}
