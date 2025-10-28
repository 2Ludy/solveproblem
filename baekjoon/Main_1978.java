package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1978 {
	
	static int N, num, count, canDiv;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			canDiv=0;
			num = Integer.parseInt(st.nextToken());
			for(int j=2; j<=(int)Math.sqrt(num); j++) {
				if(num%j == 0) {
					canDiv++;
				}
			}
			if(canDiv == 0 && num != 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
