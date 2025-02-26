package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14585 {

	static int N, M;
	static int[][] candy;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		candy = new int[301][301];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			candy[num1][num2] = M;
		}

		max = 0;

		for(int i=0; i<301; i++) {
			for(int j=0; j<301; j++) {
				// ㅁ네ㅏ어만으ㅏ으ㅏ그아그아그아그ㅏ그아그아그아그아ㅡ강그아그ㅏㅇ그아그아그아그ㅏㄱ
				// time을 어떻게 판단해야하지
				// 흠... time을 가지고 다녀야하나 ?
				//
			}
		}

	}
}
