

import java.io.*;
import java.util.*;

public class Main {
//	static int[][] memoization = new int[501][501];
	static int[][] soop;
	static int[][] v;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		soop = new int[N][N];
		v = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				soop[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				v[i][j] = -1;
			}
		}

		// 어떤지점에 판다를 놓아야 최대한 많은 칸을 방문할 수 잇는지
		// dp로 풀기 -> 1,3,5 이렇게 이동했다면 3저장
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int move = DFS(i, j);
				result = Math.max(result, move);
			}
		}

		System.out.println(result);
	}

	public static int DFS(int x, int y) {
		// 1.이미 방문했으면
		if (v[x][y] > -1) {
			return v[x][y];
		}
		
		// 2. 방문하지 않았으면
        int maxMove = 0;
		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + x;
			int nc = dc[i] + y;

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (soop[x][y] < soop[nr][nc]) 
				maxMove = Math.max(maxMove, DFS(nr,nc));
		}

		// 3. 최대 이동거리를 계산하고 v[x][y]에 저장. 이미 방문했으면 거기서부터 리턴+1
        return v[x][y] = maxMove + 1;
	}

	public static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}
}
