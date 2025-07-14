import java.util.*;
class Solution {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        
        // 괄호의 시작이 )일 경우
        if(q.peek() == ')')
            return false;
        
        int count = 0;
        while(!q.isEmpty()){
            if(q.poll() == '('){
                count++;
            }else{
                count--;
                if(count < 0) 
                    return false;
            }
        }
        return count==0;
    }
}