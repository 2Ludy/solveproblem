package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
	
	static int N, num, last;
	static String str;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			
			if(str.equals("push")) {
				queue.offer(num);
			}else if(str.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.poll()).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(queue.size()).append("\n");
			}else if(str.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(str.equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.peek()).append("\n");
				}
			}else {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					for(int lastnum : queue) {
						last = lastnum;
					}
					sb.append(last).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
