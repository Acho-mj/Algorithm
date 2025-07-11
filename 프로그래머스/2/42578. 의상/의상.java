import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        
        // HashMap으로 받기
        // 의상의 종류 Key, 갯수 Value
        for(String[] clo : clothes){
            int count = hash.getOrDefault(clo[1], 0) + 1;
            hash.put(clo[1], count);
        }
        for(int v : hash.values()){
            answer *= (v+1);
        }
        
        return answer-1;
    }
}