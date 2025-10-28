package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1244 {
	
	static int T, N;
	static int L; // 주어진 숫자의 길이
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String nums = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			L = nums.length();
			max = 0;
			
			if(N>4) N = 4;
			if(L>1) findMax(nums,0);
			
			System.out.println("#" + t + " " + max);
		}
	}

	static void findMax(String nums, int cnt) {
		if(cnt == N) {
			int val = Integer.parseInt(nums);
			max = Math.max(max, val);
			return;
		}

		for(int i=0; i<L-1; i++) {
			for(int j=i+1; j<L; j++) {
				char[] chars = nums.toCharArray();
				char tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				findMax(new String(chars), cnt+1);
			}
		}
	}
}
