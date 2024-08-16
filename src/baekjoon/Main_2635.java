package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_2635 {
	
	static int N, tmp, size;
	static List<Integer> list;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<>();
		stack.push(0);
		for(int i=1; i<=N; i++) {
			if(N == 1) {
				System.out.println(4);
				System.out.println("1 1 0 1");
				break;
			}
			tmp = i;
			list = new ArrayList<>();
			list.add(N);
			while(tmp >= 0) {
				list.add(tmp);
				size = list.size();
				tmp = list.get(size-2) - list.get(size-1);
			}
			if(stack.peek() > list.size()) {
				List<Integer> newList = new ArrayList<>();
				i = i-1;
				newList.add(N);
				while(i >= 0) {
					newList.add(i);
					size = newList.size();
					i = newList.get(size-2) - newList.get(size-1);
				}
				System.out.println(newList.size());
				StringBuilder sb = new StringBuilder();
				for(int num : newList) sb.append(num).append(" ");
				System.out.println(sb);
				break;
			}else {
				stack.push(list.size());
			}
		}
	}
}
