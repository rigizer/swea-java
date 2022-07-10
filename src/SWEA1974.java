import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	private static int[][] input_sudoku(Scanner sc) {
		int[][] sudoku_arr = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku_arr[i][j] = sc.nextInt();
			}
		}
		
		return sudoku_arr;
	}
	
	private static int check_sudoku(int[][] sudoku_arr) {
		return check_garo(sudoku_arr) == 1 
				&& check_sero(sudoku_arr) == 1 
				&& check_square(sudoku_arr) == 1
			? 1
			: 0;
	}
	
	private static boolean check_temp(int[] temp) {
		for (int i: temp) {
			if (i == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	private static int check_garo(int[][] sudoku_arr) {
		for (int i = 0; i < 9; i++) {
			int[] temp = new int[9];
			for (int j = 0; j < 9; j++) {
				temp[sudoku_arr[i][j] - 1]++;
			}
			
			if (check_temp(temp)) {
				return 0;
			}
		}
		
		return 1;
	}
	
	private static int check_sero(int[][] sudoku_arr) {
		for (int j = 0; j < 9; j++) {
			int[] temp = new int[9];
			for (int i = 0; i < 9; i++) {
				temp[sudoku_arr[i][j] - 1]++;
			}
			
			if (check_temp(temp)) {
				return 0;
			}
		}
		
		return 1;
	}
	
	private static int check_square(int[][] sudoku_arr) {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				int[] temp = new int[9];
				for (int i = 3 * a; i < 3 * a + 3; i++) {
					for (int j = 3 * b; j < 3 * b + 3; j++) {
						temp[sudoku_arr[i][j] - 1]++;
					}
				}
				
				if (check_temp(temp)) {
					return 0;
				}
			}
		}
		
		return 1;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] sudoku_arr = input_sudoku(sc);
			
			int result = check_sudoku(sudoku_arr);
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
