import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD

public class SWEA1221 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append("\n");
            int n = Integer.parseInt(st.nextToken());
            int[] data = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String d = st.nextToken();
                
                switch(d) {
                case "ZRO": data[i] = 0; break;
                case "ONE": data[i] = 1; break;
                case "TWO": data[i] = 2; break;
                case "THR": data[i] = 3; break;
                case "FOR": data[i] = 4; break;
                case "FIV": data[i] = 5; break;
                case "SIX": data[i] = 6; break;
                case "SVN": data[i] = 7; break;
                case "EGT": data[i] = 8; break;
                case "NIN": data[i] = 9; break;
                default: throw new Exception();
                }
            }
            
            Arrays.sort(data);
            
            for (int i: data) {
                switch(i) {
                case 0: sb.append("ZRO "); break;
                case 1: sb.append("ONE "); break;
                case 2: sb.append("TWO "); break;
                case 3: sb.append("THR "); break;
                case 4: sb.append("FOR "); break;
                case 5: sb.append("FIV "); break;
                case 6: sb.append("SIX "); break;
                case 7: sb.append("SVN "); break;
                case 8: sb.append("EGT "); break;
                case 9: sb.append("NIN "); break;
                default: throw new Exception();
                }
            }
            
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}
