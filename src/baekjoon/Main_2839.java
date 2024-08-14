package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839 {
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// N/5 를 한다음에 N%5가 있을거 아니야?
		// N%5 를 3으로 나누는거지 근데 3으로 나눠서 나머지가 0이면
		// 정답이고 나머지가 0이 아니면 while 문 돌려서 N%5한 값에 5씩 더하는거지
		// 그다음에 계속 나머지가 0일떄까지 나누다가 5를 계속 더한 값이 N 초과하면 멈추기
		
	}
}
