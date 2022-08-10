import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 1; tc <= 10; tc++) {
            int inputSize = Integer.parseInt(br.readLine());
            
            int result = 0;
            
            String input = br.readLine();
            String[] arr = input.split("");
            
            Stack<String> s = new Stack<>();
            
            for (String a: arr) {
                if (s.size() > 0) {
                    if (
                            (s.peek().equals("(") && a.equals(")"))
                            || (s.peek().equals("[") && a.equals("]"))
                            || (s.peek().equals("{") && a.equals("}"))
                            || (s.peek().equals("<") && a.equals(">"))
                       ) {
                        s.pop();
                        continue;
                    }
                }
                
                s.push(a);
            }
            
            if (s.isEmpty()) {
                result = 1;
            }
            
            System.out.println(String.format("#%d %d", tc, result));
        }
    }
}
