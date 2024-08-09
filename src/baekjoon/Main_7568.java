package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568 {
	
	static int N, k, rank, count;
	static int[][] people;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		people = new int[N][3]; // 0열 몸무게 , 1열 키, 2열 등수
		k = 1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		} // 생성
		
		
		for(int i=0; i<N; i++) {
			people[i][2] = 1;
			for(int j=0; j<N; j++) {
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
					people[i][2]++;
			}
		}

		for(int i=0; i<N; i++) {
			sb.append(people[i][2]).append(" ");
		}
		System.out.println(sb);
	}
}
