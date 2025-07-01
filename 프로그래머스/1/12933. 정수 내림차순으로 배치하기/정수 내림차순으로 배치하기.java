import java.util.*;
class Solution {
    public long solution(long n) {

        ArrayList<Integer> list = new ArrayList<>();
        String number = String.valueOf(n);
        for(int i=0; i<number.length(); i++){
            list.add(number.charAt(i) - '0');
        }
        
        Collections.sort(list, Comparator.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));        
        }
    
        return Long.parseLong(sb.toString());
    }
}