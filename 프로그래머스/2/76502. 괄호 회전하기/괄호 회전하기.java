import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;
        
        // i칸만큼 회전
        for(int i=0; i<n; i++){
            String rotateStr = s.substring(i) + s.substring(0, i);
            
            // 큐에 있는 괄호를 스택으로 처리
            if(isOk(n, rotateStr)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isOk(int n, String rotateStr){
        Stack<Character> st = new Stack<>();    // 괄호 짝 확인용
    
        for(char c : rotateStr.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else{
                if (st.isEmpty()) return false;
                char top = st.pop();
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return st.isEmpty();
    }
}