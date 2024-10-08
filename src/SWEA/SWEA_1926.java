package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1926 {
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
        for (int i = 1; i <= N; i++) {
            int count = 0;
            if (!check(i % 10)) count++;
            if (i >= 10 && !check((i / 10) % 10)) count++;
            if (i >= 100 && !check(i / 100)) count++;

            if (count > 0) {
                for(int c=1; c<=count; c++) {
                	sb.append("-");
                }
            } else {
                sb.append(i);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static boolean check(int num) {
        return num == 0 || num % 3 != 0;
    }
}
