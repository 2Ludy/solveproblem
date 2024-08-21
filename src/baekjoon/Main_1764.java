package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1764 {
	
	static int N, M,count;
	static String s;
	static Set<String> set;
	static List<String> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		count = 0;
		list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			s = br.readLine();
			if(set.contains(s)) {
				list.add(s);
				count++;
			}
		}
		
		Collections.sort(list);
		
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
