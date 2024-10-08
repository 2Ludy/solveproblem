package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	
	static int T;
	static int min;
	static int[] price;
	static int[] plan;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			price = new int[4]; // 0번 1일 1번 1달 2번 3달 3번 1년
			plan = new int[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) price[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) plan[i] = Integer.parseInt(st.nextToken());
			
			min = price[3];
			
			System.out.println("#" + t + " " + min);
		}
	}
}
