import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            
            int prevIdx = sb.toString().lastIndexOf(c);
            arr.add(prevIdx==-1?prevIdx:i-prevIdx);
            
            sb.append(c);
        }
        
        return arr.stream().mapToInt(i->i).toArray();
    }
}