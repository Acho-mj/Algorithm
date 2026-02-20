import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0}); // 숫자, 횟수
        
        boolean[] visited = new boolean[y+1];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curCnt = cur[1];
            
            if(curX == y){
                return curCnt;
            }
            
            int[] ops = {curX+n, curX*2, curX*3};
            for(int next : ops){
                if(next == y){
                    return curCnt+1;
                }
                
                if(next < y && !visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, curCnt+1});
                }
            }
        }
        
        return -1;
    }
}