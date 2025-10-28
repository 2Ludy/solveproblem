package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	
	static int[][] map;
	static int er;
	static int ec;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						er = i;
						ec = j;
					}
				} 
			} // map 생성
			int direction = 0; // 0이면 위방향, 1이면 왼쪽 방향, 2이면 오른쪽방향
			while(true) {
				if(er==0) {
					break;
				}
				if(direction == 0) {
					if(ec-1>=0 && map[er][ec-1] == 1) {
						ec--;
						direction = 1;
					} else if (ec+1<100 && map[er][ec+1] == 1) {
						ec++;
						direction = 2;
					} else {
						er--;
					}
				}else if(direction == 1) {
					if(map[er-1][ec] == 1) {
						er--;
						direction = 0;
					} else {
						ec--;
					} 
				} else {
					if(map[er-1][ec] == 1) {
						er--;
						direction = 0;
						continue;
					} else {
						ec++;
					} 
				}
			}
			System.out.println("#"+T+" "+ec);
		}
	}
}
