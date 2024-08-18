package baekjoon;

import java.io.*;

public class Main_12927 {
	
	static int count;
	static char[] light;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		light = br.readLine().toCharArray();
		
		count = 0;
		for(int i=0; i<light.length; i++) {
			if(light[i] == 'Y') {
				count++;
				for(int j=i; j<light.length; j=j+i+1) {
					if(light[j] == 'Y') {
						light[j] = 'N';
					}else {
						light[j] = 'Y';
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
