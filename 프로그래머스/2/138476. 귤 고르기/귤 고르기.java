import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tanSize = new HashMap<>(); 
  
        // 개수 세기
        for(int tan : tangerine){
            int count = tanSize.getOrDefault(tan, 0) + 1;
            tanSize.put(tan, count);
        }
        
        // 종류가 많은 것부터 정렬
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(tanSize.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());
        
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            k -= entry.getValue();
            count++;
            
            if(k<=0){
                break;
            }
        }
        
        return count;
    }
}