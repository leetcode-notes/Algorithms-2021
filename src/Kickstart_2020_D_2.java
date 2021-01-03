import java.io.*;
import java.util.*;

public class Kickstart_2020_D_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> aryLst = new ArrayList<>();
			aryLst.add(Integer.parseInt(st.nextToken()));
			for (int j = 1; j < K; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(aryLst.get(aryLst.size()-1) != num) aryLst.add(num);
			}
			int upCnt = 0;
			int downCnt = 0;
			int ans = 0;
			for (int j = 1; j < aryLst.size(); j++) {
				if (aryLst.get(j) > aryLst.get(j-1)) {
					upCnt += 1;
					downCnt = 0;
				} else {
					upCnt = 0;
					downCnt += 1;
				}
				if (upCnt > 3 || downCnt > 3) {
					ans++;
					upCnt = 0;
					downCnt = 0;
				}
			}
			System.out.println("Case #" + i + ": "+ans);
		}
	}
}
