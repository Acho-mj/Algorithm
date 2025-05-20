class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        // dfs 호출
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer+=1;
            }
        }
        return answer;
    }
    
    // dfs (현재 노드와 연결된 & 방문하지 않은 노드)
    private void dfs(int index, int[][] computers){
        visited[index]=true;
        for(int i=0; i<computers.length; i++){
            if(computers[index][i]==1 && !visited[i]){
                dfs(i, computers);
            }
        }
        
    }
}