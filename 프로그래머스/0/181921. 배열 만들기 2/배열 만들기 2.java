import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            
            if(numberContain(i))
                answer.add(i);
        }
        Collections.sort(answer);
        
        if (answer.isEmpty()) return new int[]{-1};
        
        int[] result = new int[(answer.size())];
        for(int j=0; j<answer.size(); j++){
            result[j] = answer.get(j);
        }
        
        return result;
    }
    
    // 0과 5가 포함되어 있는지 확인
    public boolean numberContain(int i){
        String str = String.valueOf(i);
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c != '0' && c != '5'){
                return false;
            }
        }
        return true;
    }
}