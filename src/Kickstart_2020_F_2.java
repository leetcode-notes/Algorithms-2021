import java.io.*;
import java.util.*;

public class Kickstart_2020_F_2 {
	static final int MAX_INT = 1000000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<Harvest> list = new ArrayList<>();
			int sum = 0;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.add(new Harvest(start, end));
			}
			Collections.sort(list);
			int cur = list.get(0).start+K;
			sum++;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).start >= cur) {
					cur = list.get(j).start + K;
					sum++;
				}
				if(list.get(j).end > cur) {
					while (list.get(j).end > cur) {
						sum++;
						cur += K;
					}
				}
			}
			System.out.println("Case #" + i + ": "+sum);
		}
	}
}

class Harvest implements Comparable<Harvest>{
	int start, end;

	Harvest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Harvest p) {
		if(this.end > p.end) return 1;
		else if(this.end == p.end) {
			if(this.start > p.start) return 1;
		}
		return -1;
	}
}