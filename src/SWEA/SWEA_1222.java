package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1222 {
	static int T=10;
	static int N, sum;
	static char[] chars;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=T; t++) {
			N=Integer.parseInt(br.readLine());
			chars = new char[N];
			chars = br.readLine().toCharArray();
			sum = 0;
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<N; i++) {
				stack.push(chars[i]);
			}
			Stack<Integer> results = new Stack<>();
			
			while(!stack.isEmpty()) {
				char c = stack.pop();
				 if(c == '+') {
					results.push(stack.pop()-'0');
				}else if('0'<= c && c <='9') {
					results.push(c-'0');
				}
			}
			while(!results.isEmpty()) {
				sum += results.pop();
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
