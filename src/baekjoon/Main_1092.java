package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1092 {
	
	static int N, M;
	static int[] crain;
	static List<Integer> box;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		crain = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(crain);
		Collections.sort(box);

		if(crain[N-1] < box.get(M-1)) {
			System.out.println(-1);
			return;
		}

		int time = 0;

		b: while(!box.isEmpty()) {
			a: for (int i = N - 1; i >= 0; i--) {
				int cra = crain[i];
				for (int j = box.size() - 1; j >= 0; j--) {
					int bo = box.get(j);
					if (cra >= bo) {
						box.remove(j);
						continue a;
					}
				} // 여기 포문 다 돌렷을때 빠져나오면..?
				time++;
				continue b;
			}
			time++;
		}
		System.out.println(time);
	}
}
