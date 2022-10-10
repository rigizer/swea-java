import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf

public class SWEA1767 {
    static class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private static List<Node> nodeList = new ArrayList<>();
    private static int maxCore;
    private static int minSum;
    
    // 탐색: 상, 하, 좌, 우
    private static int[] dy = {-1, 1, 0 ,0};
    private static int[] dx = {0, 0, -1, 1};
    
    private static void dfs(int[][] board, boolean[][] visited, int n, int idx, int sum, int nowCore) {
        if (idx == nodeList.size()) {
            if (maxCore < nowCore) {
                maxCore = nowCore;
                minSum = sum;
            } else if (maxCore == nowCore) {
                minSum = Math.min(minSum, sum);
            }
            
            return;
        }
        
        Node node = nodeList.get(idx);
        
        boolean isConnected = false;
        for (int d = 0; d < 4; d++) {
            boolean isOk = false;
            Queue<Node> queue = new ArrayDeque<>();
            
            int i = 0;
            while (true) {
                i++;
                int y = node.y + dy[d] * i;
                int x = node.x + dx[d] * i;
                
                if (y < 0 || y >= n || x < 0 || x >= n) {
                    isOk = true;
                    break;
                }
                
                if (board[y][x] == 1 || visited[y][x] == true) {
                    break;
                }
                
                queue.offer(new Node(y, x));
                visited[y][x] = true;
                sum++;
            }
            
            if (isOk) {
                isConnected = true;
                dfs(board, visited, n, idx + 1, sum, nowCore + 1);
            }
            
            while(!queue.isEmpty()) {
                Node temp = queue.poll();
                visited[temp.y][temp.x] = false;
                sum--;
            }
        }
        
        if (!isConnected) {
            dfs(board, visited, n, idx + 1, sum, nowCore);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            nodeList.clear();
            maxCore = 0;
            minSum = Integer.MAX_VALUE;
            
            int n = Integer.parseInt(br.readLine());
            
            int[][] board = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    
                    if (0 < i && i < n - 1 && 0 < j && j < n - 1 && board[i][j] == 1) {
                        nodeList.add(new Node(i, j));
                    } else if (board[i][j] == 1) {
                        maxCore++;
                    }
                }
            }
            
            dfs(board, visited, n, 0, 0, maxCore);
            
            bw.write(String.format("#%d %d\n", tc, minSum));
        }
        
        bw.flush();
        bw.close();
    }
}
