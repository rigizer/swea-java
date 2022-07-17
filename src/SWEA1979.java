import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();	// 배열 크기 정사각형
			int k = sc.nextInt();	// K 크기
			int r = 0;			// K 크기만큼을 가지고 있는 칸의 개수
			
			// N + 1 크기의 배열생성
			int[][] puzzle = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			// 가로 탐색
			for (int i = 0; i < n; i++) {
				int temp = 0;
				for (int j = 0; j < n + 1; j++) {
					if (puzzle[i][j] == 0) {
						if (temp != 0 && temp == k) {
							r++;
						}
						
						temp = 0;
						continue;
					}
					
					temp++;
				}
			}
			
			// 세로 탐색
			for (int j = 0; j < n; j++) {
				int temp = 0;
				for (int i = 0; i < n + 1; i++) {
					if (puzzle[i][j] == 0) {
						if (temp != 0 && temp == k) {
							r++;
						}
						
						temp = 0;
						continue;
					}
					
					temp++;
				}
			}
			
			System.out.println(String.format("#%d %d", test_case, r));
		}
	}
}
