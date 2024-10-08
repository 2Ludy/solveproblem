package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6809_NextPerm {
	
	static int T, wins, loses, sub, N=9;
	static int[] in, gyu;
	static boolean[] card;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyu = new int[N];
			card = new boolean[19];
			card[0] = true;
			for(int i=0; i<N; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			
			in = new int[N];
			int a = 0;
			for(int i=0; i<card.length; i++) {
				if(!card[i]) in[a++] = i;
			}
			wins = 0;
			loses = 0;
			
			do {
				sub = 0;
				for(int i=0; i<N; i++) {
					if(gyu[i] > in[i]) {
						sub = sub + (gyu[i] + in[i]);
					}else {
						sub = sub - (gyu[i] + in[i]);
					}
				}
				if(sub > 0) wins++;
				if(sub < 0) loses++;
			} while (np(N-1));
			
			System.out.println("#" + t + " " + wins + " " + loses);
		}
	}


	static boolean np(int size) {
		int i = size;
		while(i>0 && in[i-1] >= in[i]) i--;
		if(i==0) return false;
		int j= size;
		while(in[i-1]>=in[j]) j--;
		int temp = in[i-1];
		in[i-1] = in[j];
		in[j] = temp;
		int k = size;
		while(i<k) {
			temp = in[i];
			in[i] = in[k];
			in[k] = temp;
			i++;
			k--;
		}
		return true;
	}
}
