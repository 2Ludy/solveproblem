package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11866 { 
	
	static int N, K, index;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		index = K-1;
		sb.append("<").append(K);
		list.remove(index);
		
		while(list.size() > 0) {
			index = (index + K)%list.size()-1;
			if(index == -1)
				index = list.size()-1;
			sb.append(", ").append(list.get(index));
			list.remove(index);
		}
		sb.append(">");
		System.out.println(sb);
	}
}
