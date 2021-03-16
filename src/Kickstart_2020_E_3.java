import java.io.*;
import java.util.*;

public class Kickstart_2020_E_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Long> enjoyList = new ArrayList<>();
			ArrayList<Long> rememberList = new ArrayList<>();
			long currentCycle = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				long E = Integer.parseInt(st.nextToken());
				long R = Integer.parseInt(st.nextToken());
				enjoyList.add(E);
				currentCycle += E;
				rememberList.add(R);
			}
			long maxEnjoy = currentCycle, currentEnjoyment = currentCycle;
			int minRmCnt = 0, rmCnt = 0;

			PriorityQueue<Element> pq = new PriorityQueue<>();
			for (int j = 0; j < N; j++) {
				pq.add(new Element(enjoyList.get(j) + rememberList.get(j), j));
				currentEnjoyment += enjoyList.get(j);
				while (!pq.isEmpty()) {
					long longestCooltime = pq.peek().sum;
					int longestCooltimeId = pq.peek().index;
					if (longestCooltime <= currentCycle) break;
					else {
						currentEnjoyment -= (2 * enjoyList.get(longestCooltimeId));
						currentCycle -= enjoyList.get(longestCooltimeId);
						pq.poll();
						++rmCnt;
					}
				}
				if (maxEnjoy < currentEnjoyment) {
					maxEnjoy = currentEnjoyment;
					minRmCnt = -rmCnt;
				} else if (maxEnjoy == currentEnjoyment) {
					minRmCnt = Math.max(minRmCnt, -(rmCnt));
				}
			}
			if (!pq.isEmpty()) {
				maxEnjoy = Integer.MAX_VALUE;
				minRmCnt = -rmCnt;
			}
			if (maxEnjoy == Integer.MAX_VALUE) System.out.println("Case #" + i + ": " + -minRmCnt + " INDEFINITELY");
			else System.out.println("Case #" + i + ": " + -minRmCnt + " " + maxEnjoy);
		}
	}
}

class Element implements Comparable<Element>{
	public long sum;
	public int index;

	Element(long sum, int index) {
		this.sum = sum;
		this.index = index;
	}

	public int compareTo(Element e) {
		return e.sum >= this.sum ? 1 : -1;
	}
}
