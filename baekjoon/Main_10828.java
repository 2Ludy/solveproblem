package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828 {
	
	static int N, num;
	static String str;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			
			if(str.equals("push")) {
				stack.push(num);
			}else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(stack.size()).append("\n");
			}else if(str.equals("empty")) {
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
