package baekjoon;

import java.io.*;

public class Main_1003 {

	static int[] fibonacci;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fibonacci = new int[41];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci[2] = 1;

		for(int i=3; i<41; i++) {
			fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
		}

		for(int t=0; t<T; t++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				System.out.println(1 + " " + 0);
			} else {
				System.out.println(fibonacci[num-1] + " " + fibonacci[num]);
			}
		}
	}
}
