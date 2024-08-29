package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 { 
	
	static int N, r, c, count;
	static int[][] z;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		z = new int[1<<N][1<<N];
		
		count = 0;
		search(0,0,N);
		System.out.println(count);
		
	}

	static void search(int R, int C, int n2) {
//		if()
//		if(N == 1) {
//			for(int i=0; i<2; i++) {
//				for(int j=0; j<)
//			}
//		}else if(N == 2) {
//			
//		}else {
//			
//		}
		
	}
}
