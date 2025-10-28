package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	
	static int N, cnt1, cnt2, cnt3, cnt4, result;
	static int T = 10;
	static String s;
	static char c;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			s = br.readLine();
			
			for(int i=0; i<N; i++) {
				stack.push(s.charAt(i));
			}
			cnt1 = 0;
			cnt2 = 0;
			cnt3 = 0;
			cnt4 = 0;
			result = 0;
			
			while(!stack.isEmpty()) {
				c = stack.pop();

				switch(c) {
				case ')':
					cnt1++;
					break;
				case ']':
					cnt2++;
					break;
				case '}':
					cnt3++;
					break;
				case '>':
					cnt4++;
					break;
				case '(':
					cnt1--;
					break;
				case '[':
					cnt2--;
					break;
				case '{':
					cnt3--;
					break;
				default:
					cnt4--;
					break;
				}
			}
			if(cnt1 != 0 || cnt2 != 0 || cnt3 != 0 || cnt4 !=0) {
			}else {
				result = 1;
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
