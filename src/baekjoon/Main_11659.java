package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659 {
	
	static int N, M, hap, i, j;
	static int[] nums; // 누적합 배열로 만들꺼임 인덱스 0에는 0을 넣자.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //  N 값 받기
		M = Integer.parseInt(st.nextToken());  //  M 값 받기

		nums = new int[N+1]; // 0번 인덱스에 0을 넣으므로 총 사이즈는 N+1이 됨
		nums[0] = 0; // 0번 인덱스에 0 삽입
		hap = 0; // 누적 합을 만들 변수 초기화
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {  // 1번 인덱스부터 값 삽입
			hap += Integer.parseInt(st.nextToken());
			nums[i] = hap;  // 배열에 누적합을 저장함
		}
		
		StringBuilder sb = new StringBuilder(); // 값을 저장하기 위한 sb 설정
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken()); // 누적합이므로 nums[j] - nums[i-1] 하면됨
			j = Integer.parseInt(st.nextToken()); 
			sb.append(nums[j] - nums[i-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
