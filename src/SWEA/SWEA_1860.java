package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1860 {
	
	static int T, N, M, K, sub;
	static String status;
	static int[] arrive;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arrive = new int[N];
			st = new StringTokenizer(br.readLine());
			status = "Possible"; 
			
			for(int i=0; i<N; i++) {
				arrive[i] = Integer.parseInt(st.nextToken());
			} // 도착시간 생성
			
			Arrays.sort(arrive); // 배열 정리
			
			for(int i=0; i<N; i++) {
				sub = arrive[i]/M;
				if(sub == 0) {
					status = "Impossible";
					break;
				}else {
					if(sub*K <= i) {
						status = "Impossible";
						break;
					}
				}
			}
			sb.append("#" + t + " " + status).append("\n");
		}
		System.out.println(sb);
	}
}
