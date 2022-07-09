import java.util.Scanner;
import java.io.FileInputStream;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case);
			
			int n = sc.nextInt();			// 배열 크기 (n * n)
			int[][] arr = new int[n][n];	// 배열 초기화
			
			// 배열 입력받기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 90도 회전
			int[][] arr90 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr90[i][j] = arr[n - 1 - j][i];
				}
			}
			
			// 180도 회전
			int[][] arr180 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr180[i][j] = arr[n - 1 - i][n - 1 - j];
				}
			}
			
			// 270도 회전
			int[][] arr270 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr270[i][j] = arr[j][n - 1 - i];
				}
			}
			
			// 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr90[i][j]);
				}
				
				System.out.print(" ");
				
				for (int j = 0; j < n; j++) {
					System.out.print(arr180[i][j]);
				}
				
				System.out.print(" ");
				
				for (int j = 0; j < n; j++) {
					System.out.print(arr270[i][j]);
				}
				
				System.out.println();
			}
		}
	}
}
