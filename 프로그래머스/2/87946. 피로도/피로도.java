class Solution {
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // 탐험할 수 있는 최대 던전 수
        return dfs(k, dungeons);
    }

    // 던전(순서)
    public int dfs(int k, int[][] dungeons){
        int max=0;
        
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                int cnt = dfs(k-dungeons[i][1], dungeons) + 1;
                visited[i] = false;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}