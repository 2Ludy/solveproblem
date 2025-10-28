package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2438 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<N+1; i++) {
        	for(int j=1; j<N+1-i; j++) {
        		System.out.print(" ");
        	}
        	for(int j=N+1-i; j<N+1; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
    }
}