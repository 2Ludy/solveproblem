package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814 { 
	
	static int N;
	static String[][] strs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strs = new String[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			strs[i][0] = st.nextToken();
			strs[i][1] = st.nextToken();
		}
		
		Arrays.sort(strs, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].compareTo(o2[0]) == 0) {
					return o1.length - o2.length;
				}
				return o1[0].compareTo(o2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(strs[i][0]).append(" ").append(strs[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
