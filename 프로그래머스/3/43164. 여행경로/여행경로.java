import java.util.*;
class Solution {
    public static ArrayList<String> answer = new ArrayList<>();
    public static boolean[] visited;
    // 하나의 재귀 안에서 정렬해야함
    public static ArrayList<String> path = new ArrayList<>();
    
    private static void dfs(String start, String[][] tickets, int count){
        // 탈출 조건
        if(count==tickets.length){
            answer.add(String.join(" ", path));
            return;
        }
        
        // 수행 동작
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                // 백트래킹
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count+1);
                visited[i] = false;
                
                // 마지막에 넣은 거 제거
                path.remove(path.size() - 1);
            }
        }
        
    }
    
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];
        
        // dfs
        for(int i=0; i<n; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                
                path.clear();
                path.add("ICN");
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, 1);
                visited[i] = false;
            }
        }
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
}