package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_14555 {
	
	static int T,count;
	static char c;
	static char[] chars;
	static Stack<Character> chowon;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			chars = br.readLine().toCharArray();
			chowon = new Stack<>();
			
			for(int i=0; i<chars.length; i++) {
				chowon.push(chars[i]);
			}
			
			count = 0;
			while(!chowon.isEmpty()) {
				c = chowon.pop();
				if(c == ')') {
					chowon.pop();
					count++;
				} else if(c == '(') {
					count++;
				}
			}
			System.out.println("#"+ t + " " + count);
		}
	}
}
