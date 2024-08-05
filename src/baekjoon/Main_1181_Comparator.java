package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;



public class Main_1181_Comparator {
	
	static int N;
	static Set<String> strs; 
	static String[] str;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strs = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			strs.add(br.readLine());
		}
		str = new String[strs.size()];
		strs.toArray(str);
		
//		for(int i=str.length-1; i>=0; i--) {
//		for(int j=i; j<=str.length-2; j++) {
//			if(str[j].length() > str[j+1].length()) {
//				String tmp = str[j];
//				str[j] = str[j+1];
//				str[j+1] = tmp;
//			}else if(str[j].length() == str[j+1].length()) {
//				if(str[j].compareTo(str[j+1]) > 0) {
//					String tmp = str[j];
//					str[j] = str[j+1];
//					str[j+1] = tmp;
//				}
//			}else {
//				break;
//			}
//		}
//	}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length()-o2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : str) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
