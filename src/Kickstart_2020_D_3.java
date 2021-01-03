import java.io.*;
import java.util.*;

class Frame {
	public int treeIdx, childIdx, numChild;

	public Frame(int tidx, int cidx, int cnum) {
		treeIdx = tidx;
		childIdx = cidx;
		numChild = cnum;
	}
}

public class Kickstart_2020_D_3 {
	private static void dfs(int N, int[] probs, HashMap<Integer, ArrayList<Integer>> map, int skip) {
		LinkedList<Frame> stack = new LinkedList<>();
		int[] path = new int[N];
		int pIdx = -1;
		stack.add(new Frame(0, 0, map.containsKey(0) ? map.get(0).size() : 0));
		while (!stack.isEmpty()) {
			Frame currentFrame = stack.getLast();
			if (currentFrame.childIdx == 0) {
				path[++pIdx] = currentFrame.treeIdx;
			}
			if (currentFrame.childIdx >= currentFrame.numChild) {
				probs[currentFrame.treeIdx] += 1;
				if (pIdx >= skip) {
					probs[path[pIdx - skip]] += probs[path[pIdx]];
				}
				stack.removeLast();
				--pIdx;
			} else {
				int child = map.get(currentFrame.treeIdx).get(currentFrame.childIdx);
				stack.add(new Frame(child, 0, map.containsKey(child) ? map.get(child).size() : 0));
				++currentFrame.childIdx;
			}
		}
	}

	private static double probSum(int[] arr, int n) {
		double ret = 0.0, nd = (double) n;
		for (int num : arr) {
			ret += (double) num / nd;
		}
		return ret;
	}

	private static double probMulSum(int[] arr1, int[] arr2, int n) {
		double ret = 0.0, nd = (double) n;
		for (int i = 0, len = arr1.length; i < len; ++i) {
			ret += ((double) (arr1[i]) / nd) * ((double) (arr2[i]) / nd);
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N - 1; j++) {
				int parentNode = Integer.parseInt(st.nextToken()) - 1;
				if (!map.containsKey(parentNode)) {
					map.put(parentNode, new ArrayList<Integer>());
				}
				map.get(parentNode).add(j + 1);
			}
			int[] probA = new int[N];
			int[] probB = new int[N];
			dfs(N, probA, map, A);
			dfs(N, probB, map, B);
			double ans = probSum(probA, N) + probSum(probB, N) - probMulSum(probA, probB, N);
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}
