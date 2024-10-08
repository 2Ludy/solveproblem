package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_5432 {
	
	static int T, razer, totalSticks, hap;
	static char[] chars;
	static Queue<Character> stick;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			chars = br.readLine().toCharArray();
			stick = new LinkedList<>();
			
			razer = 0; // 레이저 닿으면 생길 막대기 수
			totalSticks = 0; // 
			hap = 0;
			
			for(int i=0; i<chars.length; i++) {
				if(chars[i] == '(') {
					if(chars[i+1] == ')') {
						hap += razer;
						i++;
					}else {
						razer++;
						totalSticks++;
					}
				}else {
					razer--;
				}
			}
			hap += totalSticks;
			System.out.println("#" + t + " " + hap);
			
//			chars = br.readLine().toCharArray();
//			stick = new LinkedList<>();
//			for(int i=0; i<chars.length; i++) {
//				stick.offer(chars[i]);
//			} // 큐에 괄호 배열 담기
//			
//			razer = 0; // 레이저 닿으면 생길 막대기 수
//			totalSticks = 0; // 
//			hap = 0;
//			
//			while(!stick.isEmpty()) {
//				char c = stick.poll();
//				if(c == '(') {
//					if(stick.peek() == ')') {
//						stick.poll();
//						hap += razer;  // 레이저에 닿았으니 hap에 막대기 수 넣어주기 
//					}else {
//						razer++;
//						totalSticks++;
//					}
//				}else {
//					razer--; // 막대기 하나씩 사라지기 
//				}
//			}
//			hap += totalSticks;
//			System.out.println("#" + t + " " + hap);
		}
    }
}
