package baekjoon;

public class Main_4673 { 
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int n=1; n<=10000; n++) {
			if(selfNum(n)) sb.append(n).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean selfNum(int n) {
		if(n<10) {
			for(int i=n/2; i<n; i++) {
				if(i+i == n) {
					return false;
				}
			}
		}else if(n<100) {
			for(int i=n/2; i<n; i++) {
				if(i+i%10+i/10 == n) {
					return false;
				}
			}
		}else if(n<1000) {
			for(int i=n-30; i<n; i++) {
				if(i+i/100+i%100/10+i%10 == n) {
					return false;
				}
			}
		}else if(n<10000) {
			for(int i=n-40; i<n; i++) {
				if(i+i/1000+i%1000/100+i%100/10+i%10 == n) {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}
}
