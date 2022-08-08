import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
    private final static int TEST_CASE = 10;
    private final static int ARRAY_SIZE = 100;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 1; tc <= TEST_CASE; tc++) {
            int limit = Integer.parseInt(br.readLine());
            
            int result = 0;
            int[] data = new int[ARRAY_SIZE];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.setAll(data, i -> Integer.parseInt(st.nextToken()));
            
            // 덤프 이동
            for (int i = 0; i < limit; i++) {
                int minIdx = 0;
                int maxIdx = 0;
                int minData = Integer.MAX_VALUE;
                int maxData = Integer.MIN_VALUE;
                
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    if (minData > data[j]) {
                        minIdx = j;
                        minData = data[j];
                    }
                    
                    if (maxData < data[j]) {
                        maxIdx = j;
                        maxData = data[j];
                    }
                }
                
                data[minIdx]++;
                data[maxIdx]--;
            }
            
            // 최대/최소 데이터 탐색
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < ARRAY_SIZE; i++) {
                minValue = Math.min(data[i], minValue);
                maxValue = Math.max(data[i], maxValue);
            }
            
            result = Math.abs(maxValue - minValue);
            System.out.println(String.format("#%d %d", tc, result));
        }
    }
}
