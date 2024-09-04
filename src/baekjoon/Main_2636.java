package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636 {
	
	static int[][] pan;
	static int[][] copyPan;
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pan = new int[R][C];
		copyPan = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
			copyPan[i] = pan[i].clone();
		}
		
		
		
		int[] s = {0,0};
		
		
	}
}
