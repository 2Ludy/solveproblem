package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_1152 {
	
	static int total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String[] sp = A.split(" ");
		if(sp.length>0 && sp[0].equals("")) {
			String[] sp1 = new String[sp.length-1];
			for(int i=0; i<sp.length-2; i++) {
				sp1[i] = sp[i+1];
			}
			System.out.println(sp1.length);
			return;
		}
		System.out.println(sp.length);
	}
}
