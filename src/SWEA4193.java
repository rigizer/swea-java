import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV

public class SWEA4193 {
    static class Node {
        int y;
        int x;
        int t;
        
        Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
        
        public String toString() {
            return String.format("y=%d, x=%d, t=%d", y, x, t);
        }
    }
    
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    
    private static int bfs(int n, int[][] pool, int a, int b, int c, int d) {
        // 방문한 좌표 기록, 선입선출 구조위해 queue 사용
        boolean[][] visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        
        // 시작위치 (a, b)를 기준으로 탐색 시작
        queue.offer(new Node(a, b, 0));
        visited[a][b] = true;
        
        while (!queue.isEmpty()) {
            // queue에 있는 node를 하나씩 빼오면서 bfs 탐색한다
            Node node = queue.poll();
            
            // 도착지에 도착한 경우 지나온 시간을 반환
            if (node.y == c && node.x == d) {
                return node.t;
            }
            
            // 4방향 탐색 (상/하/좌/우)
            for (int dir = 0; dir < 4; dir++) {
                int y = node.y + dy[dir];
                int x = node.x + dx[dir];
                
                // 다음으로 갈 곳이 수영장 범위를 벗어나거나, 섬인 경우는 탐색하지 않음
                if (y < 0 || y >= n || x < 0 || x >= n || pool[y][x] == 1) {
                    continue;
                }
                
                if (pool[y][x] == 0 && visited[y][x] == false) {
                    // 물이 있는 곳이라면, 시간을 1 증가시켜 이동
                    queue.offer(new Node(y, x, node.t + 1));
                    visited[y][x] = true;
                } else if (pool[y][x] == 2) {
                    if ((node.t + 1) % 3 == 0 && visited[y][x] == false) {
                        // 소용돌이쪽으로는 잠잠해졌을때만 이동
                        queue.offer(new Node(y, x, node.t + 1));
                        visited[y][x] = true;
                    } else if ((node.t + 1) % 3 == 1 || (node.t + 1) % 3 == 2) {
                        // 소용돌이가 몰아칠때는 제자리에
                        // 제자리에 있는 경우는 visited 조건을 확인하지 않음
                        queue.offer(new Node(node.y, node.x, node.t + 1));
                    }
                }
            }
        }
        
        // 도착할 수 없는 경우
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] pool = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    pool[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            int result = bfs(n, pool, a, b, c, d);
            
            bw.write(new StringBuilder().append("#").append(t + 1).append(" ").append(result).append("\n").toString());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
