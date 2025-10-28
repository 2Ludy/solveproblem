package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2605 { 
	
	static int N,student;
	static Queue<Integer> que;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		student = 1;
		
		while(!que.isEmpty()) {
			list.add(list.size()-que.poll(), student++);
		}
		for(int num : list) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
