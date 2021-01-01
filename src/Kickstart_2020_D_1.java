import java.io.*;
import java.util.*;

public class Kickstart_2020_D_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = -1;
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < N; j++) {
				if(j == N-1) {
					if(arr[j] > max) cnt++;
				} else {
					if(arr[j] > max && arr[j] > arr[j+1]) cnt++;
				}
				max = Math.max(arr[j], max);
			}
			System.out.println("Case #" + i + ": " + cnt);
		}
	}
}
