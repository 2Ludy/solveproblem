package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1224 {
	
	static int T=10;
	static int N, result, num1, num2;
	static char popItem;
	static char[] chars;
	static Stack<Character> stack;
	static Stack<Integer> istack;
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=T; t++) {
			N=Integer.parseInt(br.readLine());
			String s = "";
			chars = new char[N];
			chars = br.readLine().toCharArray();
			stack = new Stack<>();
			
			for(int i=0; i<chars.length; i++) {
				char c = chars[i];
				
				if('0' <= c && c <= '9') {
					s += c;
				}else if(c == '(') {
					stack.push(c);
				}else if(c==')') {
					popItem = stack.pop();
                    while (popItem != '(') {
                        s += popItem;
                        popItem = stack.pop();
                    }
				} else { // 연산자
					while(!stack.isEmpty() && stack.peek() != '(' &&
							map.get(stack.peek()) >= map.get(c)) {
						s += stack.pop();
					}
					stack.push(c);
				}
			}
			while(!stack.isEmpty()) {
				s += stack.pop();
			}
			istack = new Stack<>();
			for(char c : s.toCharArray()) {
				if('0' <= c && c <= '9') {
					istack.push(c-'0');
				}else {
					num1 = istack.pop();
					num2 = istack.pop();
					switch(c) {
					case '+' :
						result = num2 + num1;
						break;
					case '-' :
						result = num2 - num1;
						break;
					case '*' :
						result = num2*num1;
						break;
					default :
						result = num2/num1;
						break;
					}
					istack.push(result);
				}
			}
			System.out.println("#" + t + " " + istack.pop());
		}
	}
}
