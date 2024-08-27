package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {
	
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
		nPIr(0);
		System.out.println(sb);
	}

	static void nPIr(int idx) {
		if(idx == M) {
			for(int num : p) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			p[idx] = i+1;
			nPIr(idx+1);
			p[idx] = 0;
		}
	}
}
