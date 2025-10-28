package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2884 {
	
	static int H;
	static int M;
	static int sub;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sub = M-45;
		if(sub<0) {
			H--;
			sub = 60+sub;
		}
		if(H == -1) {
			H = 23;
		}
		System.out.println(H+ " " + sub);
	}
}
