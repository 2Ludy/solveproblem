package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2751 {
	
	static int N;
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = new int[2000001]; // -1,000,000~1,000,000
		
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())+1000000]++;
		} // n
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<count.length; i++) {
			if(count[i] > 0) {
				for(int j=0; j<count[i]; j++) {
					sb.append(i-1000000).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
