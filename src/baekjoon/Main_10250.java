package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250 { 
	
	static int T, H, W, N, floor, ho;
	static String sho;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			floor = N%H;
			if(floor == 0) floor = H;
			ho = N/H +1;
			if(floor == H) ho--;
			sho = Integer.toString(ho);
			
			if(ho < 10) {
				sho = "0" + sho;
			}
			sb.append(floor).append(sho).append("\n");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
