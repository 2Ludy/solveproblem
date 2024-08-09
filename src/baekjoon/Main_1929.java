package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1929 { 
	
	static int M, N, status;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = N; i<=M; i++) {
			if(i >= 5 && i % 2 == 1) {
				status = 0; // 0이면 소수 아님 1이면 소수
				for(int j = 3; j<=(int)Math.sqrt(i); j++) {
					if(i % j == 0) {
						status = 1;
						break;
					}
				}
				if(status == 0) {
					sb.append(i).append("\n");
				}
			}else if( i== 2 || i == 3) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
