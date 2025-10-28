package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_1874 {
	
	static int N;
	static int[] nums;
	static Stack<Integer> stack;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws Exception{ // 최대 500 이니까
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		que = new LinkedList<>();
		stack.push(0);
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int j = 0;
		while(j<N) {
			if(nums[j] == stack.peek()) {
				stack.pop();
				sb.append("-").append("\n");
				j++;
			}else if(nums[j] > stack.peek()) {
					stack.push(que.poll());
					sb.append("+").append("\n");
			}else {  // num < stack.peek()
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}
