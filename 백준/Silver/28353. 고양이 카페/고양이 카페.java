

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int minIndex = 0;
		int maxIndex = N - 1;
		while (minIndex < maxIndex) {
			int temp = arr[minIndex] + arr[maxIndex];
			if (temp > K) {
	            // 양 끝의 합이 K를 넘었을 때 높은 값을 줄이기.
	            maxIndex--;
	        } else if (temp < K) {
	            // 양 끝의 합이 K보다 작을 때, minIndex를 올리고, maxIndex는 내리는 과정
	            count++;
	            minIndex++;
	            maxIndex--;
	        } else if(temp == K) {
	            count++;
	            maxIndex--;
	            minIndex++;
	        }
		}
		System.out.println(count);

	}

}
