package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30802 {
	
	static int N, T, P,hap;
	static int[] size;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		size = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<6; i++) {
			if(size[i] > 0) {
			hap += (size[i]-1)/T +1;
			}
		}
		
		sb.append(hap).append("\n").append(N/P).append(" ").append(N%P);
		System.out.println(sb);
	}
}
