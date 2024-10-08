package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {
	
	static int N, T, max, sub, day, nam1, nam2;
	static int[] trees;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			trees = new int[N];
			max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			day = 0;
			nam1 = 0;
			nam2 = 0;
			
			for(int i=0; i<N; i++) {
				if(max != trees[i]) {
					int sub = max - trees[i];
					if((day+1)%2 == 1) {  // 홀수날
						if(sub%3 == 0) {
							day += sub/3*2;
						} else if(sub%3 == 1) {
							day += sub/3*2+1;
						}else {
							day += sub/3*2+2;
							nam1++;
						}
					}else {          // 짝수날
						if(sub%3 == 0) {
							day += sub/3*2;
						}else if(sub%3 == 1) {
							day += sub/3*2+2;
							nam2++;
						}else {
							day+= sub/3*2+1;
						}
					}
				}
			}
			if(nam1 > nam2) {
				day = day - ((nam1-nam2-1)*2 +1);
			}else {
				day = day - (nam2-nam1)*2;
			}
			// nam처리 해줘야되는데 여기서 흠.. 어캐하지
			System.out.println("#" + t + " " + day);
		}
    }
}
