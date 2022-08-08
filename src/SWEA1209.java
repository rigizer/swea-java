import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    private final static int TEST_CASE = 10;
    private final static int ARRAY_SIZE = 100;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 0; tc < TEST_CASE; tc++) {
            int tc_num = Integer.parseInt(br.readLine());
            
            int result = 0;
            int[][] data = new int[ARRAY_SIZE][ARRAY_SIZE];
            
            // 데이터 입력
            for (int i = 0; i < ARRAY_SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 가로 탐색
            for (int i = 0; i < ARRAY_SIZE; i++) {
                int temp = 0;
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    temp += data[i][j];
                }
                
                result = Math.max(temp, result);
            }
            
            // 세로 탐색
            for (int j = 0; j < ARRAY_SIZE; j++) {
                int temp = 0;
                for (int i = 0; i < ARRAY_SIZE; i++) {
                    temp += data[i][j];
                }
                
                result = Math.max(temp, result);
            }
            
            // 좌상우하 대각선 탐색
            int tmp = 0;
            for (int i = 0; i < ARRAY_SIZE; i++) {
                tmp += data[i][i];
            }
            
            result = Math.max(tmp,  result);
            
            // 우상좌하 대각선 탐색
            tmp = 0;
            for (int i = 0; i < ARRAY_SIZE; i++) {
                tmp += data[ARRAY_SIZE - i - 1][i];
            }
            
            result = Math.max(tmp,  result);
            
            System.out.println(String.format("#%d %d", tc_num, result));
        }
	}
}
