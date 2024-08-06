package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2292 {
	
	static int N,k,num;
	static Stack<Integer> honey;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		honey = new Stack<>();
		honey.push(1);
		k=1;
		
		while(N > honey.peek()) {
			num = honey.peek() + 6*k++;
			honey.push(num);
		}
		
		System.out.println(k);
	}
}
