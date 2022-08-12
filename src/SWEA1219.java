import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD

class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Solution {
    static int start = 0;
    static int end = 0;
    static boolean result = false;
    
    static int[][] map;
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visited;
    
    private static void bfs(int y, int x) {
        queue.offer(new Node(y, x));
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            
            for (int d = node.x; d < 100; d++) {
                if (map[node.y][d] == 0 || visited[node.y][d] == true) {
                    continue;
                }
                
                if (d == 99 && map[node.y][d] == 1) {
                    result = true;
                    return;
                }
                
                queue.offer(new Node(d, 0));
                visited[d][0] = true;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int tc_num = Integer.parseInt(st1.nextToken());
            int data_size = Integer.parseInt(st1.nextToken());
            
            result = false;
            queue.clear();
            visited = new boolean[100][100];
            
            map = new int[100][100];
            
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < data_size; i++) {
                int y = Integer.parseInt(st2.nextToken());
                int x = Integer.parseInt(st2.nextToken());
                
                map[y][x] = 1;
            }
            
            bfs(0, 0);
            
            System.out.println(String.format("#%d %d", t, result ? 1 : 0));
        }
    }
}
