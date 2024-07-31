package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2738 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] array1 = new int[N][M];
		int[][] array2 = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				array1[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				array2[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				array1[i][j] += array2[i][j];
				System.out.print(array1[i][j]+" ");
			}
			System.out.println();
		}
	}
}
