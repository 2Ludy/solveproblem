package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2444 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=2*N-1; i++) {
			for(int j=1; j<=Math.abs(N-i); j++) {    // 공백이 4,3,2,1,0,1,2,3,4 니까 math.abs(N-i)
				System.out.print(" ");
			}
			for(int j=Math.abs(N-i)+1; j<2*N-Math.abs(N-i); j++) { // 별찍기 해당 위치부터 1 3 5 7 9 7 5 3 1 니까 2N-1-|N-i|
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
