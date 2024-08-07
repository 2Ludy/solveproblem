package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814 { 
	
	static int N, k;
	static String[][] strs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strs = new String[N][3];
		k=1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			strs[i][0] = st.nextToken();
			strs[i][1] = st.nextToken();
			strs[i][2] = Integer.toString(k++);
		}
		
		Arrays.sort(strs, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				}
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(strs[i][0]).append(" ").append(strs[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
