package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_20019 {
	
	static int T,l;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		a : for(int t=1; t<=T; t++) {
			char[] cs;
			cs = br.readLine().toCharArray(); // char 배열 생성
			l=cs.length;
			
			for(int i=0; i<l/2; i++) {
				if(cs[i] != cs[l-1-i]) {
					System.out.println("#"+t+" NO");
					continue a;
				}
			}
			
			for(int i=0; i<l/4; i++) {
				if(cs[i] != cs[l/2-1-i] || cs[l-1-i] != cs[(l-1)/2 + i + 1]) {
					System.out.println("#"+t+" NO");
					continue a;
				}
			}
			
//			for(int i=0; i<l/4; i++) {
//				if(cs[l-1-i] != cs[(l-1)/2 + i + 1]) {
//					System.out.println("#"+t+" NO");
//					continue a;
//				}
//			}
			System.out.println("#"+t+" YES");
		}
	}
}
