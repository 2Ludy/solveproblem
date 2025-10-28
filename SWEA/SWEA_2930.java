package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2930 {
	
	static int T, N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>(new Comparator<Integer>(){

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}} );
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}else {
					if(!pq.isEmpty()) {
						sb.append(pq.poll()).append(" ");
					}
					else {
						sb.append("-1").append(" ");
					}
				}
			}
			System.out.println(sb);
		}
	}
}
