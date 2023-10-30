
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String str = "666";
		int cnt = 0;
		String result = "";
		int j = 0;
		while(cnt < N) {
			j++;
			if(String.valueOf(j).contains(str)) {
				cnt++;
				result = String.valueOf(j);
			}
		}
		
		System.out.println(result);
	}

}
