package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	
	static int L, C;
	static char[] alpha;
	static char[] com;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new char[C];
		com = new char[L];
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alpha);

		logic(0,0);

		System.out.print(sb);
	}

	static void logic(int idx, int cnt) {
		if(cnt == L) {
			int count = 0;
			for(int i=0; i<L; i++) {
				char c = com[i];
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
			}
			if(count >= 1 && L-count >=2) {
				for(int i=0; i<L; i++) {
					sb.append(com[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for(int i=idx; i<C; i++) {
			com[cnt] = alpha[i];
			logic(i+1, cnt+1);
		}
	}
}