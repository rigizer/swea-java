import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD

class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class SWEA1226 {
	static int sy, sx, ey, ex;
    static boolean result = false;
    
    static char[][] map = new char[16][16];
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visited;
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static void bfs(int y, int x) {
        queue.offer(new Node(y, x));
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if (ny < 0 || nx < 0 || ny >= 16 || nx >= 16 || visited[ny][nx] == true || map[ny][nx] == '1') {
                    continue;
                }
                
                if (ny == ey && nx == ex) {
                    result = true;
                    return;
                }
                        
                queue.offer(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            
            result = false;
            queue.clear();
            visited = new boolean[16][16];
            
            for (int i = 0; i < 16; i++) {
                map[i] = br.readLine().toCharArray();
                
                for (int j = 0; j < 16; j++) {
                    if (map[i][j] == '2') {
                        sy = i;
                        sx = j;
                    } else if (map[i][j] == '3') {
                        ey = i;
                        ex = j;
                    }
                }
            }
            
            bfs(sy, sx);
            
            System.out.println(String.format("#%d %d", t, result ? 1 : 0));
        }
    }
}
