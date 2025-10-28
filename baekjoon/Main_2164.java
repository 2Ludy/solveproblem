package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164 {
	
	static int N, tmp;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			if(que.size() >= 3) {
				que.poll();
				tmp = que.poll();
				que.offer(tmp);
			}else {
				que.poll();
			}
		}
		System.out.println(que.poll());
	}
}
