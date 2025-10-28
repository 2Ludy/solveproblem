package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 { 
	
	static int K, num, hap;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		
		for(int i=0; i<K; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}
		
		hap = 0;
		for(int n : stack) {
			hap += n;
		}
		
		System.out.println(hap);
	}
}
