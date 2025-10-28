package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499 {
	
	static int T, N;
	static Queue<String> front; // 큐로 안풀어도 될거같은데??
	static Queue<String> back;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			front = new LinkedList<>();
			back = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=(N+1)/2; i++) {
				front.offer(st.nextToken());
			}
			for(int i=(N+1)/2+1; i<=N; i++) {
				back.offer(st.nextToken());
			}
			
			sb.append("#").append(t).append(" ");
			while(!front.isEmpty()) {
				sb.append(front.poll()).append(" ");
				if(!back.isEmpty()) {
					sb.append(back.poll()).append(" ");
				}
			}
			sb.delete(sb.length()-1, sb.length()); // 맨 마지막 공백 지우기
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
