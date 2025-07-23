import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for(String s : participant){
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }
        for(String s : completion){
            hash.put(s, hash.get(s) - 1);
        }
        // 카운트가 1인 사람이 완주하지 못한 사람
        for(String key : hash.keySet()){
            if(hash.get(key) != 0){
                return key;
            }
        }
        return ""; 
    }
}