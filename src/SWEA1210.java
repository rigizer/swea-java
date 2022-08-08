import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
    private final static int TEST_CASE = 10;
    private final static int ARRAY_SIZE = 100;
    
    private final static int NON_LADDER = 0;
    private final static int LADDER = 1;
    private final static int LADDER_END = 2;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 1; tc <= TEST_CASE; tc++) {
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
            
            // 몇번 사다리를 타야하는지
            int idxGaro = 0;
            while (idxGaro < ARRAY_SIZE) {
                if (data[0][idxGaro] == NON_LADDER) {
                    //System.out.println("idxGaro 탐색패스: " + idxGaro);
                    idxGaro++;
                    continue;
                }
                
                int i = 0;
                int j = idxGaro;
                
                int dirStatus = 0;  // 0 : 초기값, 1 : 왼쪽이동, 2 : 오른쪽이동
                
                //System.out.println("idxGaro 탐색시작: " + idxGaro);
                //System.out.println(String.format("[%d]    [%d][%d]", idxGaro, i, j));
                
                // 라인 탐색
                while (i < ARRAY_SIZE) {
                    // 왼쪽 이동가능한 경우 왼쪽으로 이동
                    if (dirStatus != 2) {
                        if (j - 1 >= 0 && data[i][j - 1] == LADDER) {
                            dirStatus = 1;
                            j--;
                            //System.out.println("왼쪽이동");
                            //System.out.println(String.format("[%d]    [%d][%d]", idxGaro, i, j));
                        }
                    }
                    
                    // 오른쪽 이동가능한 경우 오른쪽으로 이동
                    if (dirStatus != 1) {
                        if (j + 1 < ARRAY_SIZE && data[i][j + 1] == LADDER) {
                            dirStatus = 2;
                            j++;
                            //System.out.println("오른쪽 이동");
                            //System.out.println(String.format("[%d]    [%d][%d]", idxGaro, i, j));
                        }
                    }
                    
                    // 아래로 내려가기
                    if (i + 1 <= ARRAY_SIZE - 1 && (data[i + 1][j] == LADDER || data[i + 1][j] == LADDER_END)) {
                        dirStatus = 0;
                        i++;
                        //System.out.println("아래로 내려가기");
                        //System.out.println(String.format("[%d]    [%d][%d]", idxGaro, i, j));
                    }
                    
                    if (i >= ARRAY_SIZE - 1) {
                        //System.out.println(String.format(":[%d]    [%d][%d]", idxGaro, i, j));
                        break;
                    }
                }
                
                if (data[ARRAY_SIZE - 1][j] == LADDER_END) {
                    // 사다리 끝의 값이 2이면 idxGaro의 사다리를 이용해야 한다
                    result = idxGaro;
                    //System.out.println("found: " + result);
                    
                    break;
                }
                
                idxGaro++;
            }
            
            System.out.println(String.format("#%d %d", tc_num, result));
        }
    }
}
