package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main_3052_Set이용 {
	
	static final int N = 10;
	static int[] nums = new int[42];
	static Set<Integer> count = new HashSet();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<N; i++) {
			count.add(Integer.parseInt(br.readLine())%42);
		}
		System.out.println(count.size());
	}
}
