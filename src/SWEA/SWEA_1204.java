package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {
	static int T;
	static int N;
	static int score;
	static int binSu;
	//static int[] students = new int[1000];
	//static int[] scores = new int[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] students = new int[1000];
			int[] scores = new int[101];
			for(int j=0; j<1000; j++) {
				students[j] = Integer.parseInt(st.nextToken());
				scores[students[j]]++;
			}
			score=0;
			binSu=0;
			for(int j=0; j<101; j++) {
				if(scores[j] >= score) {
					score = scores[j];
					binSu=j;
				}
			}
			System.out.println("#" + N +" " + binSu);
		}
	}
}
