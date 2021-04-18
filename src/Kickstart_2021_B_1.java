import java.io.*;
import java.util.*;

public class Kickstart_2021_B_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			char[] charArr = s.toCharArray();
			StringBuilder sb = new StringBuilder("");
			int idx = -1;
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(charArr[j]-'A' > idx) cnt++;
				else cnt = 1;
				idx = charArr[j]-'A';
				sb.append(cnt+ " ");
			}
			System.out.println("Case #" + i + ": "+sb.toString());
		}
	}
}
