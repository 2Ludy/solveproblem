package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_CT {
	
	static int T, x1, y1, x2, y2, gun, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			x2 = Math.abs(x2 - x1);
			y2 = Math.abs(y2 - y1);
			
			gun = (x2+y2)/2;
			result = Math.abs(x2-gun) + Math.abs(y2 - gun) + gun*2;
			System.out.println("#" + t + " " + result);
		}
	}
}
