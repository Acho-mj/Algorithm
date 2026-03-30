import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        
        // 사고 싶은 물건과 갯수
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> discountMap = new HashMap<>();
        // 첫날
        for(int i=0; i<10; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
        }
        if(isMatch(wantMap, discountMap)) answer++;
        
        // 슬라이딩
        for(int i=1; i<=n-10; i++){
            String prev = discount[i-1];
            if(discountMap.get(prev) == 1){
                discountMap.remove(prev);
            }else{
                discountMap.put(prev, discountMap.get(prev) - 1);
            }
            
            String next = discount[i-1+10];
            discountMap.put(next, discountMap.getOrDefault(next, 0)+1);
            
            if(isMatch(wantMap, discountMap)) answer++;
        }
        
        return answer;
    }
    
    private boolean isMatch(HashMap<String, Integer> wantMap, HashMap<String, Integer> discountMap){
        for(String key : wantMap.keySet()){
            if(discountMap.getOrDefault(key, 0) < wantMap.get(key)){
                return false;
            }
        }
        return true;
    }
}