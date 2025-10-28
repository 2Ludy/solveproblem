package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
	
	static int N, M;
	static String s;
	static List<String> pokemon;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pokemon = new ArrayList<>();
		map = new HashMap<>();
		
		pokemon.add("0");
		for(int i=1; i<=N; i++) {
			s=br.readLine();
			pokemon.add(s);
			map.put(s, i);
			
		}
		
		for(int i=0; i<M; i++) {
			s=br.readLine();
			if(s.matches("\\d+")) {
				System.out.println(pokemon.get(Integer.parseInt(s)));;
			}else {
				System.out.println(map.get(s));
			}
		}
	}
}
