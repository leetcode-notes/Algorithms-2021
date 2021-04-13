import java.io.*;
import java.util.*;

public class Kickstart_2021_A_3 {
	static int[] dRow = {1, 0, -1, 0};
	static int[] dCol = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int houses[][] = new int[R + 2][C + 2];
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);;
			HashMap<Integer, ArrayList<Point>> hm = new HashMap<>();
			for (int j = 0; j <= R + 1; j++) {
				houses[j][0] = -1;
				houses[j][C + 1] = -1;
			}
			for (int k = 0; k <= C + 1; k++) {
				houses[0][k] = -1;
				houses[R + 1][k] = -1;
			}
			for (int j = 1; j <= R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= C; k++) {
					int height = Integer.parseInt(st.nextToken());
					houses[j][k] = height;
					if (!pq.contains(height)) pq.add(height);
					if (hm.containsKey(height)) {
						ArrayList<Point> list = hm.get(height);
						list.add(new Point(j, k));
						hm.replace(height, list);
					} else {
						ArrayList<Point> list = new ArrayList<>();
						list.add(new Point(j, k));
						hm.put(height, list);
					}
				}
			}
			long sumBoxes = 0L;
			while (!pq.isEmpty()) {
				int topHeight = pq.poll();
				ArrayList<Point> list = hm.get(topHeight);
				for (int x = 0; x < list.size(); x++) {
					Point p = list.get(x);
					int pRow = p.row;
					int pCol = p.col;
					for (int n = 0; n < 4; n++) {
						int nRow = pRow + dRow[n];
						int nCol = pCol + dCol[n];
						if (nRow > 0 && nRow <= R && nCol > 0 && nCol <= C) {
							if (houses[nRow][nCol] >= topHeight - 1) continue;
							else {
								// nRow, nCol 좌표의 기존 높이를 hm에서 삭제한다.
								ArrayList<Point> list3 = hm.get(houses[nRow][nCol]);
								for(int m = 0; m < list3.size(); m++) {
									if(list3.get(m).row == nRow && list3.get(m).col == nCol) {
										list3.remove(m);
										break;
									}
								}
								hm.replace(houses[nRow][nCol], list3);

								// nRow, nCol 좌표의 높이를 topHeight-1까지 높여준다.
								sumBoxes += topHeight - 1 - houses[nRow][nCol];
								houses[nRow][nCol] = topHeight - 1;
								if (!pq.contains(topHeight - 1)) pq.add(topHeight - 1);
								if (hm.containsKey(topHeight - 1)) {
									ArrayList<Point> list2 = hm.get(topHeight - 1);
									list2.add(new Point(nRow, nCol));
									hm.replace(topHeight - 1, list2);
								} else {
									ArrayList<Point> list2 = new ArrayList<>();
									list2.add(new Point(nRow, nCol));
									hm.put(topHeight - 1, list2);
								}
							}
						}
					}
				}
			}
			System.out.println("Case #" + i + ": " + sumBoxes);
		}
	}
}

class Point {
	public int row, col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
