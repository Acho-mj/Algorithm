import java.util.*;
class Solution {
    ArrayList<String> arr = new ArrayList<>();
    String[] order = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        // 모든 경우의 수 만들기
        dfs("", 0);
        
        return arr.indexOf(word) + 1;
    }
    
    private void dfs(String word, int length){
        if(length == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            String next = word + order[i];
            arr.add(next);
            
            dfs(next, length + 1);
        }
    }
}