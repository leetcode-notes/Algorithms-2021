import java.io.*;
import java.util.*;

public class Kickstart_2020_E_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] diff = new int[N];
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			int cnt = 1;
			int max = 1;
			for(int j = 1; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				diff[j-1] = arr[j] - arr[j-1];
				if (j >= 2) {
					if (diff[j-1] == diff[j-2]) cnt++;
					else {
						max = Math.max(cnt, max);
						cnt = 2;
					}
				} else cnt++;
			}
			max = Math.max(cnt, max);
			System.out.println("Case #" + i + ": " + max);
		}
	}
}
