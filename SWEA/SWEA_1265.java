package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1265 {
	
	static int T, N, P, div, na;
	static long total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			div = N/P;
			na = N%P;
			total = 1;
			
			for(int i=1; i<=P-na; i++) {
				total = total*div;
			}
			
			for(int i=1; i<=na; i++) {
				total = total*(div+1);
			}
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}
}
