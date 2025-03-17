import java.util.Scanner;

public class Main {
    public static int n, m;
    public static char[][] graph;
    public static int count = 0; 

    public static void dfs(int x, int y) {
        // 범위 벗어나면 return
        if (x < 0 || x >= n || y < 0 || y >= m) 
            return;

        // 벽이거나 이미 방문한 곳이면 return
        if (graph[x][y] == 'X' || graph[x][y] == 'V') 
            return;

        // 방문 처리, 친구(P) 만나면 count 증가
        if (graph[x][y] == 'P') count++;  
        // 방문한 곳 표시
        graph[x][y] = 'V';  

        // 상하좌우 DFS 탐색
        dfs(x, y - 1);
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y + 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new char[n][m];
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
                
                // 'I' (헌내기 위치) 찾기
                if (graph[i][j] == 'I') {  
                    startX = i;
                    startY = j;
                }
            }
        }
        
        // 헌내기 위치에서 DFS 시작
        dfs(startX, startY);

        System.out.println((count == 0) ? "TT" : count); 
    }
}
