import java.util.*;
class Solution {
    boolean solution(String s) {
        // 괄호 처리
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c=='('){
                st.push(c);
            }else{
                if(st.isEmpty())
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}