

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// 친구의 친구면 친구다.
		// 모든사람과 친구면 1점, 다른 모든사람과 친구거나, 친구의 친구면 2점
		// 주의 -> 친구사면서 동시에 친구의 친구사이면 친구사이다. -> 경로가 적은쪽을 따라감. -> 모든 정점에서의 최단거리를 구하고 최단거리가
		// 가장 큰 값이 친구 점수가 된다.
		// 회장은 회원들중 점수가 가장 작은 사람이 된다.
		// 2차원 -> 플로이드 워샬

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j)
					arr[i][j] = INF;
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == -1 && y == -1)
				break;

			arr[x][y] = arr[y][x] = 1; // 친구 관계는 양방향
		}

		// 플로이드 와샬 알고리즘 수행 -> 모든 정점 사이의 최단 경로를 찾기
		for (int k = 1; k <= N; k++) {// 중간 정점을 선택하는 역할
			for (int i = 1; i <= N; i++) {// 출발 정점
				for (int j = 1; j <= N; j++) {// 도착 정점
					if (arr[i][j] > arr[i][k] + arr[k][j]) {// 지금 값보다 작으면 갱신
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

	
		// 최단거리가 제일 큰 값이 친구 점수가 된다.
		int[] MaxScore = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int score = 0;
			for (int j = 1; j <= N; j++) {
				if(arr[i][j]>score && arr[i][j]!=INF)
					score = arr[i][j];
			}
			MaxScore[i] = score;
		}
//		System.out.println(Arrays.toString(MaxScore));
		
		//제일 작은 값 추출
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			if(MaxScore[i]<min) {
				cnt = 0;
				sb = new StringBuilder();
				min = MaxScore[i];
				sb.append(i+" ");
				cnt ++;
			}else if(MaxScore[i]==min) {
				sb.append(i+" ");
				cnt ++;
			}
		}
		System.out.println(min+" "+cnt);
		System.out.print(sb.toString().trim());
		
//		//출력
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(arr[i][j] + ", ");
//			}
//			System.out.println();
//		}

	}

}
