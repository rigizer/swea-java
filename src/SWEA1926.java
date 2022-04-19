import java.util.Scanner;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=1926&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String n = Integer.toString(test_case);
			
			n = n.replaceAll("3", "-")
					.replaceAll("6", "-")
					.replaceAll("9", "-");
			n = n.contains("-") ? n.replaceAll("[0-9]", "") : n;
			
			System.out.print(n);
			
			if (test_case != T) {
				System.out.print(" ");
			}
		}
	}
}
