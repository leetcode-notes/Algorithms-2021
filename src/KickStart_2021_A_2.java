import java.io.*;
import java.util.*;

public class KickStart_2021_A_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int arr[][] = new int[R+2][C+2]; // 0: wall, 1: empty, 2: fill
			for (int j = 1; j <= R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= C; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken())+1;
				}
			}
			int ans = 0;
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if((arr[j-1][k] == 2 || arr[j+1][k] == 2) && (arr[j][k-1] == 2 || arr[j][k+1] == 2) && arr[j][k] == 2) {
						int topDirBlock = 0, leftDirBlock = 0, bottomDirBlock = 0, rightDirBlock = 0;
						for(int m = j-1; m >= 1; m--) {
							if(arr[m][k] == 2) topDirBlock++;
							else break;
						}
						for(int n = k+1; n <= C; n++) {
							if(arr[j][n] == 2) rightDirBlock++;
							else break;
						}
						for(int m = j+1; m <= R; m++) {
							if(arr[m][k] == 2) bottomDirBlock++;
							else break;
						}
						for(int n = k-1; n >= 1; n--) {
							if(arr[j][n] == 2) leftDirBlock++;
							else break;
						}
						ans += lShapeCount(topDirBlock, rightDirBlock, bottomDirBlock, leftDirBlock);
					}
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}

	static int lShapeCount(int top, int right, int bottom, int left) {
		int sum = 0;
		sum += twoNumCount(Math.max(top, left), Math.min(top, left));
		sum += twoNumCount(Math.max(top, right), Math.min(top, right));
		sum += twoNumCount(Math.max(bottom, left), Math.min(bottom, left));
		sum += twoNumCount(Math.max(bottom, right), Math.min(bottom, right));
		return sum;
	}

	static int twoNumCount(int longer, int shorter) {
		if (longer < 3 || shorter < 1) return 0;
		int sum = 0;
		sum += Math.min(((longer+1)/2)-1, shorter);
		sum += Math.min(((shorter+1)/2)-1, longer);
		return sum;
	}
}