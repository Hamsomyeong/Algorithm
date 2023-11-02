import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순 정렬
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(arr, num, 0, N - 1));
		}

	}
	
	private static int binarySearch(int[] arr, int target, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return 1;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return 0;
	}
}
