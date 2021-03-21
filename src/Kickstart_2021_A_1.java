import java.io.*;
import java.util.*;

public class Kickstart_2021_A_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			char[] charArr = br.readLine().toCharArray();
			int gdScore = 0;
			for(int j = 0; j < N/2; j++) {
				if(j != N-j-1 && charArr[j] != charArr[N-j-1]) gdScore++;
			}
			System.out.println("Case #" + i + ": "+Math.max(K - gdScore, 0));
		}
	}
}
