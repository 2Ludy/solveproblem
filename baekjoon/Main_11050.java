package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050 {
	
	static int N, K, n, k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		n = 1;
		k = 1;
		
		for(int i=0; i<K; i++) {
			n = n*(N-i);
			k = k*(K-i);
		}
		System.out.println(n/k);
	}
}