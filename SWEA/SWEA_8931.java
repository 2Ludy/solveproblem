package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931 {
	
	static int T, K, total, num, cnt;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			
			for(int i=0; i<K; i++) {
				stack.push(Integer.parseInt(br.readLine()));
			}
			cnt = 0;
			total = 0;
			while(!stack.isEmpty()) {
				num = stack.pop();
				if(num == 0) {
					cnt++;
				} else {
					if(cnt > 0) {
						cnt--;
					}else {
						total += num;
					}
				}
			}
		System.out.println("#" + t + " " + total);	
		}
	}
}
