package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726 {
	
	static int T, N, M, carrot;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			N = (1<<N)-1;  // 2의N제곱 -1 로 만들어서 1 1 1 1 같은것 나타내기
			M = Integer.parseInt(st.nextToken());
			
			carrot = M^N; // XOR 연산
			if(carrot == M-N) { // XOR연산과 M-N값이 같다면, M의 마지막 N개 비트가 모두 1임
				System.out.println("#"+t+" "+"ON");
			}else { // 아니면 M의 마지막 N개 비트가 모두 1이 아니라는 것
				System.out.println("#"+t+" "+"OFF");
			}
		}
	}
}
