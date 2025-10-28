package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5099 {
	
	static class Pizza{
		int index;
		int C;
		public Pizza(int index, int c) {
			super();
			this.index = index;
			C = c;
		}
	}
	
	static int T;
	static int N,M;
	static Queue<Pizza> ovens;
	static Queue<Pizza> pizzas;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pizzas = new LinkedList<>();
			ovens = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				pizzas.offer(new Pizza(i+1, Integer.parseInt(st.nextToken())));
			}
			
			for(int i=0; i<N; i++) {
				ovens.offer(pizzas.poll());
			}
			
			while(ovens.size() > 1) {
				Pizza p = ovens.poll();
				p.C = p.C/2;
				if(p.C == 0) {
					if(!pizzas.isEmpty()) {
						ovens.offer(pizzas.poll());
					}
				}else { 
					ovens.offer(p);
				}
			}
			sb.append("#").append(t).append(" ").append(ovens.poll().index).append("\n");
		}
		System.out.println(sb);
	}
}