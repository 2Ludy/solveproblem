package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7102 {
	
	static int T, N, M, tmp1, tmp2, max;
	static Queue<Integer> fc;  // front card
	static Queue<Integer> bc;  // back card
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			fc = new LinkedList<>();
			bc = new LinkedList<>();
			
			for(int i=1; i<=N; i++) {
				fc.offer(i);
			}
			
			for(int i=1; i<=M; i++) {
				bc.offer(i);
			}
			
			count = new int[N+M+1];
			
			for(int i=0; i<N; i++) {
				tmp1 = fc.poll();
				for(int j=0; j<M; j++) {
					tmp2 = bc.poll();
					count[tmp1+tmp2]++;
					bc.offer(tmp2);
				}
				fc.offer(tmp1);
			}
			max = (N+M)/2+1;
			for(int i=0; i<count.length; i++) {
				if(count[max] == count[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
