import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Kickstart_2020_E_2 {
	final static String IMP = "IMPOSSIBLE";
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + solution());
		}
	}

	private static String solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		List<Integer> heights = new LinkedList<>();
		String ans = "";
		for (int j = 0; j < C; j++) {
			heights.add(N);
		}
		for (int j = 0; j < A - C; j++) {
			heights.add(0, N - j - 1);
		}
		for (int j = 0; j < B - C; j++) {
			heights.add(heights.size(), N - j - 1);
		}
		if (heights.size() < N) {
			int hi = 0;
			if (C > 1) {
				hi = A - C + 1;
			} else if (A > C) {
				hi = A - C;
			} else if (B > C) {
				hi = heights.size() - B + C;
			} else {
				return IMP;
			}
			for (int j = heights.size(); j < N; j++) {
				heights.add(hi, 1);
			}
		}
		if (heights.size() != N) return IMP;
		ans = heights.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
		return ans;
	}
}
