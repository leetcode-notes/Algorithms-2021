import java.io.*;
import java.util.*;

public class Kickstart_2020_F_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			PriorityQueue<Person> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int withdraw = Integer.parseInt(st.nextToken());
				pq.add(new Person(j, (withdraw-1)/X));
			}
			StringBuilder ans = new StringBuilder();
			while (!pq.isEmpty()) {
				ans.append(pq.poll().num+" ");
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}

class Person implements Comparable<Person>{
	int num, multiples;

	Person(int num, int multiples) {
		this.num = num;
		this.multiples = multiples;
	}

	@Override
	public int compareTo(Person p) {
		if(this.multiples > p.multiples) return 1;
		else if(this.multiples == p.multiples) {
			if(this.num > p.num) return 1;
		}
		return -1;
	}
}
