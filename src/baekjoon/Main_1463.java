package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1463 {
	
	static int N, count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
//		// 1순위 3나누기 2순위 2로 나누기 3순위 1빼기
//		count = 0;
//		while(N>1) {
//			if(N%3 == 0) {
//				N = N/3;
//			}else if(N%2 == 0) {
//				N = N/2;
//			} else {
//				N--;
//			}
//			System.out.println(N);
//			count++;
//		}
////		System.out.println(count);
	}
}
