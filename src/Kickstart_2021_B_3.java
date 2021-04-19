import java.io.*;
import java.util.*;

public class Kickstart_2021_B_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			long Z = Long.parseLong(br.readLine());
			PriorityQueue<Long> pq =new PriorityQueue<>((x, y) -> Long.compare(y, x));
			long ans = 0;
			long idx = (long)Math.sqrt((double)Z);
			while(idx > 0) {
				if(!isPrime(idx)) {
					idx--;
					continue;
				} else {
					pq.add(idx);
					idx--;
					if(pq.size() == 3) break;
				}
			}
			idx = (long)Math.sqrt((double)Z);
			while(idx < 10000000000L) {
				idx++;
				if(!isPrime(idx)) {
					continue;
				} else {
					pq.add(idx);
					break;
				}
			}
			if(pq.size() == 2) {
				long first = pq.poll();
				long second = pq.poll();
				ans = first*second;
			} else if(pq.size() == 3) {
				long first = pq.poll();
				long second = pq.poll();
				long third = pq.poll();
				ans = first * second;
				if (ans > Z) ans = second * third;
			} else if(pq.size() == 4) {
				long first = pq.poll();
				long second = pq.poll();
				long third = pq.poll();
				long fourth = pq.poll();
				ans = first*second;
				if(ans > Z) ans = second*third;
				if(ans > Z) ans = third*fourth;
			}
			System.out.println("Case #" + i + ": "+ans);
		}
	}

	static boolean isPrime(long l) {
		if(l == 0 || l == 1) return false;
		if(l == 2 || l == 3) return true;
		for(long i = 2; i*i <= l; i++) {
			if(l%i == 0) return false;
		}
		return true;
	}
}
