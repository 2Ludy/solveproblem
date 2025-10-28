package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959 {
	
	static int T, N, M, mul, max;
	static int[] numsN, numsM;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			numsN = new int[N];
			numsM = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numsN[i] = Integer.parseInt(st.nextToken());
			} // numsN 설정
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				numsM[i] = Integer.parseInt(st.nextToken());
			} // numsM 설정
			
			max = -2000000000;
			
			if(N>M) {
				for(int i=0; i<N-M; i++) {
					mul = 0;
					for(int j=0; j<M; j++) {
						mul += numsN[i+j]*numsM[j];
					}
					max = Math.max(max, mul);
				}
			}else if (N == M) {
				max = 0;
				for(int i = 0; i<N; i++) {
					mul += numsN[i]*numsM[i];
				}
			}else {
				for(int i=0; i<=M-N; i++) {
					mul = 0;
					for(int j=0; j<N; j++) {
						mul += numsN[j]*numsM[i+j];
					}
					max = Math.max(max, mul);
				}
			}
			System.out.println("#" + t + " " + max);
		}
    }
}
