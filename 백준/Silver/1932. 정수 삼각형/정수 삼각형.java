

import java.util.*;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[N][N+1];
		dp[0][1] = Integer.parseInt(br.readLine());
		int result = dp[0][1];
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<i+2; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(i<0||i>N||j-1<0||j>N)
					continue;
				
				if(dp[i][j] < num+dp[i-1][j-1])
					dp[i][j] = num+dp[i-1][j-1];
				if(dp[i][j] < num+dp[i-1][j])
					dp[i][j] = num+dp[i-1][j];
				if(result<dp[i][j])
					result = dp[i][j];
			}
		}
		System.out.println(result);
	}

}
