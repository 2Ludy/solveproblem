package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_15829 {
	
	static int L;
	static BigInteger hap;
	static int M = 1234567891;
	static int r = 31;
	static char[] chars;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		chars = new char[L];
		hap = BigInteger.ZERO;
		
		chars = br.readLine().toCharArray();
		
		for(int i=0; i<L; i++) {
			BigInteger charValue = BigInteger.valueOf(chars[i] - 'a' + 1);
	        BigInteger rPower = BigInteger.valueOf(r).pow(i);
	        hap = hap.add(charValue.multiply(rPower));
	    	}
		hap = hap.mod(BigInteger.valueOf(M));
		System.out.println(hap);
	}
}
