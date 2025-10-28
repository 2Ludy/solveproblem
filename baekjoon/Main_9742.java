package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9742 {
	
	static int N, M, count;
	static StringBuilder sb;
	static char[] chars;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			String s = st.nextToken();
			chars = s.toCharArray();
			N = Integer.parseInt(st.nextToken());
			M = chars.length;
		
			sb = new StringBuilder();
			sb.append(s).append(" ").append(N).append(" = ");
		
			if(fact(M) < N) {
				sb.append("No permutation");
				System.out.println(sb);
				continue;
			}
			count = 0;
			do {
				count++;
				if(count == N) {
					for(char c : chars) {
					sb.append(c);
					}
					break;
				}
			} while (NP(M-1));
			System.out.println(sb);
		}
	}

	static int fact(int m) {
		if(m == 0 || m == 1) return 1; 
		return m*fact(m-1);
	}

	static boolean NP(int size) {
		int i = size;
		while(i>0 && chars[i-1] >= chars[i]) i--;
		if(i==0) return false;
		int j= size;
		while(chars[i-1]>=chars[j]) j--;
		char temp = chars[i-1];
		chars[i-1] = chars[j];
		chars[j] = temp;
		int k = size;
		while(i<k) {
			temp = chars[i];
			chars[i] = chars[k];
			chars[k] = temp;
			i++;
			k--;
		}
		return true;
	}
}
