package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1676 {
	
	static int N;
	
	public static void main(String[] args) throws Exception{ // 최대 500 이니까
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(N/125 + N/25 + N/5);
	}
}
