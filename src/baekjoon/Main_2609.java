package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
	
	static int num1, num2, yak, bae;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		yak = gcd(num1, num2);
		System.out.println(yak);
		System.out.println(num1*num2/yak);
	}
	
	
	// 최대공약수와 최대공배수 구하기
	// 원래 막 빼기로 구하는데
	// 오래걸리니까 모듈러스(%)를 이용하는 방법이 있음
	// 예를 들어서 24,18이 있다고 하면 아래를 통하면
	// (24,18) -> (6,18) -> (6,0) >> 최대공약수:6
	// 최소공배수는 24 x 18 / 최대공약수 
	static int gcd(int num1, int num2) {
		if(num1 == 0) {
			return num2;
		}else if(num2 == 0) {
			return num1;
		}else if(num1>num2) {
			return gcd(num1%num2, num2);
		}else if(num1<num2) {
			return gcd(num1, num2%num1);
		}else {
			return num1;
		}
	}
}
