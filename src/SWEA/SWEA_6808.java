package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	
	static int T, wins, loses, sub;
	static int[] in, gyu, p;
	static boolean[] card, visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyu = new int[9];
			card = new boolean[19];
			card[0] = true;
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			
			in = new int[9];
			int a = 0;
			for(int i=0; i<card.length; i++) {
				if(!card[i]) in[a++] = i;
			}
			wins = 0;
			loses = 0;
			visited = new boolean[9];
			p = new int[9];
			nPr(0);
			System.out.println("#" + t + " " + wins + " " + loses);
		}
	}

	static void nPr(int idx) {
		if(idx == 9) {
			sub = 0;
			for(int i=0; i<9; i++) {
				if(gyu[i] > p[i]) {
					sub = sub + gyu[i] + p[i];
				}else {
					sub = sub - (gyu[i] + p[i]);
				}
			}
			if(sub > 0) wins++;
			if(sub < 0) loses++;
			return;
		}
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[idx] = in[i];
			nPr(idx+1);
			p[idx] = 0;
			visited[i] = false;
			
		}
	}
}
