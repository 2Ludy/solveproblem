package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613 {
	
	static int T, N, M, count, min;   // status = 0 흰, status = 1 파, status = 2 빨
	static char[][] flag;  // W = 0, B = 1 , R = 2
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			for(int i=0; i<N; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
			min=2000000;
			for(int i=0; i<N-2; i++) {
				for(int j=i+1; j<N-1; j++) {
					count = 0;
					
					for(int r=0; r<=i; r++) {
						for(int c=0; c<M; c++) {
							if(flag[r][c] != 'W') count++;
						}
					}
					
					for(int r=i+1; r<=j; r++) {
						for(int c=0; c<M; c++) {
							if(flag[r][c] != 'B') count ++;
						}
					}
					for(int r = j+1; r<N; r++) {
						for(int c=0; c<M; c++) {
							if(flag[r][c] != 'R') count++;
						}
					}
					min = Math.min(min, count);
				}
			}
			System.out.println("#" + t + " " + min);
		}
    }
}
