package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_teacher {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			int tot=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(nums));
			
			for(int j=2; j<N-2; j++) {
			//	if(nums[j] > nums[j-1] && nums[j] > nums[j-2] && nums[j] > nums[j+1] && nums[j] > nums[j+2]) {
				int sub = nums[j]-Math.max(Math.max(nums[j-1], nums[j-2]), Math.max(nums[j+1], nums[j+2]));
				if(sub > 0) {
					tot += sub;
				}
			}
			System.out.println("#" + i + " " + tot);
		}
	}
}
