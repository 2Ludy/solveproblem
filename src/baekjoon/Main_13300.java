package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300 {
	
	static int N, K, num, count;
	static int[] rooms;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		rooms = new int[12];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken())*6 + Integer.parseInt(st.nextToken())-1;
			rooms[num]++;
		}
		
		for(int i=0; i<12; i++) {
			if(rooms[i] > 0) {
				if(rooms[i]%K > 0) {
					count += rooms[i]/K+1;
				}else {
					count += rooms[i]/K;
				}
			}
		}
		System.out.println(count);
	}
}
