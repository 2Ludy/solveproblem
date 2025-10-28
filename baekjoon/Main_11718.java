package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11718 { // BufferedReader에서 값이 없어 null 값이 input 될때 예외처리
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ="";
		while((line = br.readLine()) != null) { // BufferedReader에서 값이 없어 null 값이 input 될때 예외처리
			StringTokenizer st = new StringTokenizer(line);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			System.out.println(num1 + num2);
		}
	}
}
