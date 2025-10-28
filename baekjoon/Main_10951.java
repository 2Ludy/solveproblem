package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10951 { // BufferedReader에서 값이 없어 null 값이 input 될때 예외처리
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ="";
		while((line = br.readLine()) != null) { // BufferedReader에서 값이 없어 null 값이 input 될때 예외처리
			System.out.println(line);
		}
	}
}
