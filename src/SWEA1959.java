import java.util.Scanner;

class Solution
{
	private static int[] input_arr(int arr_size, Scanner sc) {
		int[] arr = new int[arr_size];
		
		for (int i = 0; i < arr_size; i++) {
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}
	
	private static int get_max(int a_size, int b_size, int[] a_arr, int[] b_arr) {
		int diff = a_size - b_size;
		int max = 0;
		
		for (int d = 0; d <= diff; d++) {
			int temp = 0;
			
			for (int i = 0; i < b_size; i++) {
				int t1 = a_arr[i + d];
				int t2 = b_arr[i];
				
				temp += t1 * t2;
			}
			
			max = Math.max(max, temp);
		}
		
		return max;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a_size = sc.nextInt();
			int b_size = sc.nextInt();
			
			int[] a_arr = input_arr(a_size, sc);
			int[] b_arr = input_arr(b_size, sc);
			
			int max = 0;
			if (a_size == Math.max(a_size, b_size)) {
				max = get_max(a_size, b_size, a_arr, b_arr);
			} else {
				max = get_max(b_size, a_size, b_arr, a_arr);
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
