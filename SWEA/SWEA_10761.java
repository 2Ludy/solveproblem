package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_10761 {
	
	static int T, N, bLocation, oLocation,bIndex, oIndex, bGo, oGo, time, index;
	static Queue<Integer> B, O;
	static String[] inputStrs;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			inputStrs = br.readLine().split(" ");
			
			N = Integer.parseInt(inputStrs[0]);
			
			B = new LinkedList<>();
			O = new LinkedList<>();
			index = 1;
			
			for(int i=1; i < inputStrs.length; i=i+2) {
				if(inputStrs[i].equals("B")) {
					B.offer(Integer.parseInt(inputStrs[i+1]));
					B.offer(index++);
				}else {
					O.offer(Integer.parseInt(inputStrs[i+1]));
					O.offer(index++);
				}
			}
			
			bLocation = 1;
			oLocation = 1;
			if(!B.isEmpty()) {
				bGo = B.poll();
				bIndex = B.poll();
			}else {
				bIndex = 2000000001;
			}
			if(!O.isEmpty()) {
				oGo = O.poll();
				oIndex = O.poll();
			}else {
				oIndex = 2000000001;
			}
			time = 0;
			
			while(!(O.isEmpty() && oGo==0 && B.isEmpty() && bGo==0)) {
				if(!B.isEmpty() || bGo != 0) {
//					if(bGo == 0) {
//						bGo = B.poll();
//						bIndex = B.poll();
//					}
					if(bGo == bLocation) {
						if(bIndex < oIndex) {
							bGo = 0;
						}
					}else if(bGo < bLocation) {
						bLocation--;
					}else {
						bLocation++;
					}
				}
				
				if(!O.isEmpty() || oGo != 0) {
//					if(oGo == 0) {
//						oGo = O.poll();
//						oIndex = O.poll();
//					}
					if(oGo == oLocation) {
						if(oIndex < bIndex) {
							oGo = 0;
						}
					}else if(oGo < oLocation) {
						oLocation--;
					}else {
						oLocation++;	
					}
				}
				time++;
				
				if(B.isEmpty()&&bGo == 0) {
					bIndex = 2000000000;
				}else if(!B.isEmpty() && bGo == 0) {
					bGo = B.poll();
					bIndex = B.poll();
				}
				
				if(O.isEmpty()&&oGo == 0) {
					oIndex = 2000000000;
				}else if(!O.isEmpty() && oGo == 0) {
					oGo = O.poll();
					oIndex = O.poll();
				}
			}
			System.out.println("#" + t + " " + time);
		}
    }
}
