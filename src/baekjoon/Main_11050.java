package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11050 {
	
	static int N, K, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = 1;
		
		for(int i=0; i<K; i++) {
			C = C * ((N-i)/(K-i));
		}
		
		System.out.println(C);
	}
}