package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_9012 {
	
	static int N;
	static char c;
	static String s;
	static Stack<Character> stack;
	static Queue<Character> que;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a: for(int i=0; i<N; i++) {
			stack = new Stack<>();
			que = new LinkedList<>();
			s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				stack.push(s.charAt(j));
			}
			c = stack.pop();
			if(c == '(') {
				System.out.println("NO");
				continue a;
			}else {
				que.offer(c);
			}
			
			while(!stack.isEmpty()) {
				c = stack.pop();
				if(c=='(') {
					if(que.isEmpty()) {
						System.out.println("NO");
						continue a;
					}else {
						que.poll();
					}
				}else {
					que.offer(c);
				}
			}
			if(que.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}