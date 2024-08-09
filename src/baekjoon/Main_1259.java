package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1259 {
	
	static int l,status;
	static char[] chars;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = "";
		while(!((s = br.readLine()).equals("0"))) {
			
			chars = s.toCharArray();
			l = chars.length;
			status = 0;
		
			for(int i=0; i<l/2; i++) {
				if(chars[i] != chars[l-i-1]) {
					status = 1;
					break;
				}
			}
			if(status == 0) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	}
}
