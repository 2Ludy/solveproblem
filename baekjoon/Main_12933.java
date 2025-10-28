package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_12933 {

	static String duck;
	static Queue<Integer> q;
	static Queue<Integer> u;
	static Queue<Integer> a;
	static Queue<Integer> c;
	static Queue<Integer> k;
	static List<int[]> list;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		duck = br.readLine();
		q = new LinkedList<>();
		u = new LinkedList<>();
		a = new LinkedList<>();
		c = new LinkedList<>();
		k = new LinkedList<>();
		list = new ArrayList<>();

		for(int i=0; i<duck.length(); i++) {
			char ch = duck.charAt(i);
			if(ch == 'q') {
				q.offer(i);
			}else if(ch == 'u') {
				u.offer(i);
			}else if(ch == 'a') {
				a.offer(i);
			}else if(ch == 'c') {
				c.offer(i);
			}else {
				k.offer(i);
			}
		}
		int qi = -1;
		int ui = -1;
		int ai = -1;
		int ci = -1;
		int ki = -1;

		while(true) {
			if(q.isEmpty() && u.isEmpty() && a.isEmpty() && c.isEmpty() && k.isEmpty()) {
				break;
			}

			if(!q.isEmpty()) {
				qi = q.poll();
			}

			if(!u.isEmpty()) {
				ui = u.poll();
			}

			if(!a.isEmpty()) {
				ai = a.poll();
			}

			if(!c.isEmpty()) {
				ci = c.poll();
			}

			if(!k.isEmpty()) {
				ki = k.poll();
			}

			if(qi == -1 || ui == -1 || ai == -1 || ci == -1 || ki == -1) {
				System.out.println(-1);
				return;
			}

			if(qi > ui) {
				System.out.println(-1);
				return;
			}

			if(qi > ai) {
				System.out.println(-1);
				return;
			}

			if(qi > ci) {
				System.out.println(-1);
				return;
			}

			if(qi > ki) {
				System.out.println(-1);
				return;
			}

			if(ui > ai) {
				System.out.println(-1);
				return;
			}

			if(ui > ci) {
				System.out.println(-1);
				return;
			}

			if(ui > ki) {
				System.out.println(-1);
				return;
			}

			if(ai > ci) {
				System.out.println(-1);
				return;
			}

			if(ai > ki) {
				System.out.println(-1);
				return;
			}

			if(ci > ki) {
				System.out.println(-1);
				return;
			}

			list.add(new int[] {qi,ki});

			qi = -1;
			ui = -1;
			ai = -1;
			ci = -1;
			ki = -1;

		}

		Queue<int[]> que = new LinkedList<>();
		count = 1;
		for(int i=0; i<list.size(); i++) {
			if(que.isEmpty()) {
				que.offer(list.get(i));
			}else {
				int[] nums = que.peek();
				int peekStart = nums[0];
				int peekEnd = nums[1];

				int newStart = list.get(i)[0];
				int newEnd = list.get(i)[1];

				if(peekEnd > newStart) {
					que.add(list.get(i));
				}else {
					que.poll();
					que.add(list.get(i));
				}
			}
			count = Math.max(count,que.size());
		}

		System.out.println(count);

	}
}
