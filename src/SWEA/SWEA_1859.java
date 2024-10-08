package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
	
	static int T, N, max;
	static long hap;
	static int[] prices;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			prices = new int[N];
			hap = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
            max = prices[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] < max) {
                    hap += max - prices[i];
                } else {
                    max = prices[i];
                }
            }
			sb.append("#" + t + " " + hap).append("\n");
		}
		System.out.println(sb);
	}
}
