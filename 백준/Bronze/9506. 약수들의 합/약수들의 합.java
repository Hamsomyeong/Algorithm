

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0;
		while (N >= 0) {
			N = Integer.parseInt(br.readLine());

			if (N != -1) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 1; i < N; i++) {
					if (N % i == 0) {
						list.add(i);
					}
				}
				int sum = 0;
				for (Integer num : list) {
					sum += num;
				}
				if (sum == N) {

					System.out.print(N + " = ");
					for (int i = 0; i < list.size(); i++) {
						if(list.size()-1==i)
						System.out.print(list.get(i));
						else System.out.print(list.get(i)+" + ");
					}
					System.out.println();
				}else {
					System.out.println(N+" is NOT perfect.");
				}
				
			}

		}
	}

}
