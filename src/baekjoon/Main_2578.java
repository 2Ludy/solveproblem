package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2578 { 
	
	static int b, tmp, count;
	static int[][] bingo;
	static Queue<Integer> que;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[5][5];
		que = new LinkedList<>();
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
		}
		b=0;
		count = 1;
		while(b<3) {
			tmp = que.poll();
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(bingo[i][j] == tmp) {
						bingo[i][j] = 0;
						break;
					}
				}
			}
			if(count >= 13) {
				//check 로직
				// 체크로직 어떻게 짜지 흠...
			}
			count++;
		}
	}
}
