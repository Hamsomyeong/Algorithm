import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//두 사람이 서로 이기는 방향으로 게임을 했을 때
		//1,3,4로 가져갈 수 있음.
		//상근이는 초기 돌수가 1,3,4일때는 무조건 이김 -> dp[0]=false, dp[1]=true, dp[3]=true, dp[4]=true
		//2개일때는 -> 둘다 false로 무승부
		//dp 배열은 상근이 이길 수 있는지 저장, 돌을 5~N 까지 볼때 
		//현재상태에서 1,3,4개의 돌을 가져가면 승리할수있는지 확인, dp[i - 1], dp[i - 3], dp[i - 4] 이중 하나라도 0이면 상근이 승리 가능. 
		int dp[] = new int[1001];
		
//		dp[0]=0;
		dp[1]=1;
		dp[3]=1;
		dp[4]=1;
		
		for(int i=5; i<N+1; i++) {
			if(dp[i-1]==0||dp[i-3]==0||dp[i-4]==0)
				dp[i]=1;
		}
		
//		System.out.println(Arrays.toString(dp));
		
		if(dp[N]==1) System.out.println("SK");
		else System.out.println("CY");
	}

}