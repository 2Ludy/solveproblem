package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1920 {
	
	static int N, M, result;
	
	static int[] nums;
	
	static Queue<Integer> finds;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		finds = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			finds.offer(Integer.parseInt(st.nextToken()));
		}
				
		while(!finds.isEmpty()) {
			result = Arrays.binarySearch(nums, finds.poll());
			if(result >= 0) {
				result = 1;
			}else {
				result = 0;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
