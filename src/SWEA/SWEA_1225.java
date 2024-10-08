package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	
	static int T=10, N=8;
	static int[] nums = {1,2,3,4,5};
	static int TC, p, i;
	static Queue<Integer> password;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t);
			TC = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			password = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				password.offer(Integer.parseInt(st.nextToken()));
			} // 패스워드 큐 생성
			i = 0;
			while(true) {
				p = password.poll();
				p = p-nums[i++];
				if(p<=0) {
					p = 0;
					password.offer(p);
					break;
				}else {
					password.offer(p);
					if(i>4) i = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				sb.append(" ").append(password.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}