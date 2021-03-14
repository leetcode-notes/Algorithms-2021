import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Kickstart_2020_E_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[] heights = new int[N];
			String ans = "";
			if (A + B - C > N || (A + B - C == 1 && N >= 2)) ans = "IMPOSSIBLE";
			else if (N == 1) {
				heights[0] = 1;
			} else if (N == 2) {
				if (C == 2) {
					heights[0] = 2;
					heights[1] = 2;
				} else if (A == 2) {
					heights[0] = 1;
					heights[1] = 2;
				} else if (B == 2) {
					heights[0] = 2;
					heights[1] = 1;
				} else ans = "IMPOSSIBLE";
			} else {
				for (int j = 0; j < N; j++) {
					if (j < A - C || j >= N - (B - C)) heights[j] = 2;
					else heights[j] = 3;
				}
				int cnt = N - (A + B - C);
				for (int j = A - C + 1; j < N - (B - C); j++) {
					if (cnt > 0) {
						heights[j] = 1;
						cnt--;
					}
				}
				ans = Arrays.stream(heights)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(" "));
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}
