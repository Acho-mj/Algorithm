import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int num : nums){
            int count = hash.getOrDefault(num, 0)+1;
            hash.put(num, count);
        }
        
        return hash.size() > n ? n : hash.size();
    }
}