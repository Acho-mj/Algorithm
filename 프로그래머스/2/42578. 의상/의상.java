import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();
        int n=0;
        // HashMap으로 받기
        // 의상의 종류 Key, 갯수 Value
        for(String[] clo : clothes){
            hash.put(clo[1],  hash.getOrDefault(clo[1], 0) + 1);
        }
        // 의상 조합(+1 : 안 입는 경우)
        int answer=1;
        for(String key : hash.keySet()){
            answer *= (hash.get(key)+1);
        }
        
        return answer-1;
    }
}