package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1230 {
	
	static int N, M, x, y, s;
	static int T = 10;
	static List<Integer> pwd;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			pwd = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				pwd.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String command = st.nextToken();
				if(command.equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int i=0; i<y; i++) {
						s = Integer.parseInt(st.nextToken());
						pwd.add(x+i,s);
					}
				}else if(command.equals("D")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int i=0; i<y; i++) {
						pwd.remove(x);
					}
				}else {
					y = Integer.parseInt(st.nextToken());
					for(int i=0; i<y; i++) {
						s = Integer.parseInt(st.nextToken());
						pwd.add(s);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<10; i++) {
				sb.append(pwd.get(i)).append(" ");
			}
			System.out.println("#" + t + " " +sb);
		}
    }
}
