package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4458 { 
	
	static int N;
	static String[] strs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strs = new String[N];
		
		for(int i=0; i<N; i++) {
			strs[i] = br.readLine();
			String str = strs[i].substring(0, 1);
			str = str.toUpperCase();
			strs[i] = str+strs[i].substring(1);
			System.out.println(strs[i]);
		}
	}
}
