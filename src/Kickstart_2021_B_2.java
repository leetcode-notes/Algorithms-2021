import java.io.*;
import java.util.*;

public class Kickstart_2021_B_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] diffs = new int[N];
			HashMap<Integer, ArrayList<Sequence>> hm = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			int diff = 0;
			int max = 0;
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if(j >= 1) {
					diffs[j-1] = arr[j]-arr[j-1];
					if(j == 1) {
						cnt++;
						diff = diffs[0];
					} else {
						if(diffs[j-1] == diff) {
							cnt++;
							if(j == N-1) {
								if(hm.containsKey(diff)) {
									ArrayList<Sequence> aryList = hm.get(diff);
									aryList.add(new Sequence(j-cnt+1,j+1));
									hm.put(diff, aryList);
								} else {
									ArrayList<Sequence> aryLst = new ArrayList<>();
									aryLst.add(new Sequence(j-cnt+1,j+1));
									hm.put(diff, aryLst);
								}
							}
						} else {
							if(hm.containsKey(diff)) {
								ArrayList<Sequence> aryList = hm.get(diff);
								aryList.add(new Sequence(j-cnt,j));
								hm.put(diff, aryList);
							} else {
								ArrayList<Sequence> aryLst = new ArrayList<>();
								aryLst.add(new Sequence(j-cnt,j));
								hm.put(diff, aryLst);
							}
							cnt = 1;
							diff = diffs[j-1];
						}
					}
				} else cnt++;
			}

			for(Integer key : hm.keySet()) {
				ArrayList<Sequence> aryList = hm.get(key);
				int exStart = aryList.get(0).start;
				int exEnd = aryList.get(0).end;
				if(aryList.size() == 1) {
					max = Math.max(Math.min(N, exEnd - exStart + 2), max);
					continue;
				}
				for(int j = 1; j < aryList.size(); j++) {
					Sequence seq = aryList.get(j);
					if (seq.start - exEnd == 1) {
						max = Math.max(Math.max(seq.end - seq.start + 2, exEnd - exStart + 2), max);
					} else if (seq.start - exEnd == 2) {
						if(diffs[exEnd] + diffs[exEnd+1] == diffs[exEnd-1]*2) max = Math.max(seq.end - exStart + 1, max);
						else max = Math.max(Math.max(seq.end - seq.start + 2, exEnd - exStart + 2), max);
					}
					exStart = seq.start;
					exEnd = seq.end;
				}
			}

			System.out.println("Case #" + i + ": "+max);
		}
	}
}

class Sequence {
	int start, end;

	Sequence(int start, int end) {
		this.start = start;
		this.end = end;
	}
}