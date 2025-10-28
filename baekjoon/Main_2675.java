package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675 {
	
	static int T;
	static int R;
	static char[] cs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			cs = st.nextToken().toCharArray();
			
			for(int i=0; i<cs.length; i++) {
				for(int j=0; j<R; j++) {
					sb.append(cs[i]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
