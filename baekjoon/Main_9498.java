package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9498 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String grade = "ABCDFFFFFF"; //"FFFFFFDCBAA"
		System.out.print(grade.charAt((100-N)/10));
	}
}