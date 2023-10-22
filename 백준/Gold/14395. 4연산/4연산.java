

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		long s = Long.parseLong(st.nextToken());
		long t = Long.parseLong(st.nextToken());

		// *,+,-,/ 를 모든 상황에서 진행해야함 -> 재귀함수
		resursive(s, t);
		bw.close();
	}

	public static void resursive(long s, long t) throws IOException {
		// 아스키 코드 순서대로 배열 생성
		String[] order = new String[] { "*", "+", "-", "/" };
		// 중복 체크
		HashSet<Long> set = new HashSet<>();

		if (s == t) {
			bw.write("0");
			return;
		}

		Queue<Num> Q = new LinkedList<>();
		set.add(s);
		Q.add(new Num(s, ""));

		while (!Q.isEmpty()) {
			Num now = Q.poll();

			long nowNum = now.num;
			String nowStack = now.stack;

			// 목표 숫자에 도달하면 현재까지 해왔던 연산 출력
			if (nowNum == t) {
				bw.write(nowStack);
				return;
			}

			long nextNum = nowNum; // 연산 후의 숫자
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					nextNum = nowNum * nowNum;
					break;
				case 1:
					nextNum = nowNum + nowNum;
					break;
				case 2:
					nextNum = nowNum - nowNum;
					break;
				case 3:
					if (nowNum != 0)
						nextNum = nowNum / nowNum;
					break;
				}

				if (!set.contains(nextNum)) {
					set.add(nextNum);
					Q.add(new Num(nextNum, nowStack + order[i]));
				}
			}
		}
		
		bw.write("-1");
	}

	public static class Num {
		long num;
		String stack;

		public Num(long num, String stack) {
			super();
			this.num = num;
			this.stack = stack;
		}
	}
}
