package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1970 {
	
	static int T, N ;
	static int[] count;
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			count = new int[8];
			
			for(int i=0; i<8; i++) {
				count[i] = N/money[i];
				N = N%money[i];
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for(int num : count) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
		}
	}
}
