package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816 { 
	
	static int N, M;
	static int[] count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = new int[20000001];
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(count[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		System.out.println(sb);
	}
}
