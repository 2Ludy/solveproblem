package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11723 { 
	
	static int N;
	static int num;
	static Set<Integer> set;
	static String s;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			if(s.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			}else if(s.equals("check")) {
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(s.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			}else if(s.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				}else {
					set.add(num);
				}
			}else if(s.equals("all")) {
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
			}else {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}
