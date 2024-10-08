package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644 {
	
	static int T, M, A;
	static int[] aMove, bMove;
	static int[][] BC;
	static int[][] map;
	static int Charging, hap;
	static int Ar, Ac, Br, Bc;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			aMove = new int[M+1];
			bMove = new int[M+1];
			
			aMove[0] = 0;
			bMove[0] = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<M+1; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			} // aMove 받기
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<M+1; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			} // bMove 받기
			
			BC = new int[A][4]; // 0열=x좌표, 1열=y좌표, 2열=충전범위, 3열=처리량
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			} // BC 정보 받기
			
			hap = 0;
			
			Ar = 1;
			Ac = 1;
			Br = 10;
			Bc = 10;
			
			for(int i=0; i<M+1; i++) {
				amoving(aMove[i]); // Ar, Ac 갱신
				bmoving(bMove[i]); // Br, Bc 갱신
				
				List<Integer> a = new ArrayList<>();
				List<Integer> b = new ArrayList<>();
				
				batteryCharger(Ar, Ac, a);
				batteryCharger(Br, Bc, b);
				
				// 여기서 이제 충전량 비교 해야함
				Charging = 0;
				charge(a,b);
				hap += Charging;
			}
			System.out.println("#" + t + " " + hap);
		}
	}

	static void charge(List<Integer> a, List<Integer> b) {
		if(a.size()== 0 && b.size()==0) {
			return;
		}else if(a.size() == 0) {
			for(int i=0; i<b.size(); i++) {
				Charging = Math.max(Charging, BC[b.get(i)][3]);
			}
		}else if(b.size() == 0) {
			for(int i=0; i<a.size(); i++) {
				Charging = Math.max(Charging, BC[a.get(i)][3]);
			}
		}else {
			for(int i=0; i<a.size(); i++) {
				for(int j=0; j<b.size(); j++) {
					if(a.get(i) == b.get(j)) {
						Charging = Math.max(Charging, BC[a.get(i)][3]);
					}else {
						Charging = Math.max(Charging, BC[a.get(i)][3]+BC[b.get(j)][3]);
					}
				}
			}
		}
	}

	static void batteryCharger(int r, int c, List<Integer> list) {
		for(int i=0; i<A; i++) {
			if(Math.abs(r-BC[i][0])+Math.abs(c-BC[i][1]) <= BC[i][2]) {
				list.add(i);
			}
		}
	}

	static void amoving(int m) {
		if(m == 0) { // 이동 x
			return;
		}else if(m == 1) { // 위
			Ac--;
		}else if(m == 2) { // 우
			Ar++;
		}else if(m == 3) { // 하
			Ac++;
		}else { // 좌
			Ar--;
		}
	}
	
	static void bmoving(int m) {
		if(m == 0) { // 이동 x
			return;
		}else if(m == 1) { // 위
			Bc--;
		}else if(m == 2) { // 우
			Br++;
		}else if(m == 3) { // 하
			Bc++;
		}else { // 좌
			Br--;
		}
	}
}
