import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1206 {
    private final static int TEST_CASE = 10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= TEST_CASE; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] building = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.setAll(building, i -> Integer.parseInt(st.nextToken()));
            
            int result = 0;
            
            parent:
            for (int i = 2; i < n - 2; i++) {
                int viewOk = Integer.MAX_VALUE;
                for (int j = i - 2; j <= i + 2; j++) {
                    if (i == j) {
                        continue;
                    }
                    
                    int diff = building[i] - building[j];
                    if (diff <= 0) {
                        continue parent;
                    }
                    
                    viewOk = Math.min(diff, viewOk);
                }
                
                result += viewOk;
            }
            
            System.out.println(String.format("#%d %d", t, result));
        }
    }
}
