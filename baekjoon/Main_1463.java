package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// dp[i] = i를 1로 만드는데 필요한 최소 연산 횟수
		int[] dp = new int[N + 1];

		// 상향식(Bottom-up) 접근
		for (int i = 2; i <= N; i++) {
			// 1을 빼는 연산
			dp[i] = dp[i - 1] + 1;

			// 2로 나누어 떨어지는 경우
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			// 3으로 나누어 떨어지는 경우
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		System.out.println(dp[N]);
	}
}
