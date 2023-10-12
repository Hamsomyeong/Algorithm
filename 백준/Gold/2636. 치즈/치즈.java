

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] cheese;
	static boolean[][] v;
	static int[] dr = {0,1,-1,0};
	static int[] dc = {1,0,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
	}
	
	private static class Point{
		int r = 0;
		int c = 0;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	
	private static void BFS() {
		int roll = 0;
		int remain = 0;
		L: while(true) {
			roll++;
			remain = 0;
			Queue<Point> Q = new LinkedList<>();
			v = new boolean[N][M];
			
			Q.add(new Point(0,0));
			v[0][0] = false;
			
			//BFS로 타고갈 수 있는 0들에 인접한 1만 2로 표시
			while(!Q.isEmpty()) {
				Point p = Q.poll();
			
				for (int j = 0; j < 4; j++) {
					int nr = p.r+dr[j];
					int nc = p.c+dc[j];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) continue;
					if(cheese[nr][nc]==0)
						Q.add(new Point(nr,nc));
					if(cheese[nr][nc]==1) {
						remain++;
						cheese[nr][nc] = 2;
					}
					v[nr][nc] = true;
				}
			}
			
			//2로된 치즈 0으로 녹이기
			//1가 없으면 다 녹음.
			int stop =0;
			for(int i = 0; i < N; i++) {
				for(int j=0; j < M; j++) {
					if(cheese[i][j]==2)
						cheese[i][j]= 0;
					if(cheese[i][j]==1)
						stop++;
				}
			}
			
//			printLog();
			if(stop == 0) break L;
			
		}
		System.out.println(roll);
		System.out.println(remain);
	}
	
	public static void printLog(){
		for(int i = 0; i < N; i++) {
			for(int j=0; j < M; j++) {
				System.out.print(cheese[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
