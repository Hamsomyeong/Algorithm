import java.util.Scanner;

public class Main {
	
	static int[][] dp = new int[30][30];
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
			
			int N = in.nextInt();	
			int M = in.nextInt();
						
			sb.append(combi(M, N)).append('\n');
		}
		
		System.out.println(sb);
		
	}
	

	static int combi(int n, int r) {
		
		// 이미 풀린 경우 바로 반환
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		// 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		//m 개 중에서 n 개를 뽑을 경우의 수를 의미하며 겹치는 것은 없다.
		//조합을 구할 때 규칙이 있다. mCn 을 구하기 위해서는 m-1Cn-1 + m-1Cn  으로 구할 수 있다는 것
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}