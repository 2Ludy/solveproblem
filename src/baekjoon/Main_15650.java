package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
	
	static int N, M;
	static StringBuilder sb;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		p = new int[M];
		sb = new StringBuilder();
		nCr(0, 0);
		System.out.println(sb);
	}

	static void nCr(int idx, int cnt) {
		if(idx == M) {
			for(int num : p) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			p[idx] = i+1;
			nCr(idx+1, i+1);
			p[idx] = 0;
		}
	}
}
