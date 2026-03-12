import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        int targetLen = n - k;
        Stack<Character> st = new Stack<>();
        
        // 스택에 큰 값 넣기(이전 값 보다 클 경우)
        for(int i=0; i<n; i++){
            char c = number.charAt(i);
            
            while(!st.isEmpty() && st.peek() < c && k > 0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        for(int i=0; i<targetLen; i++){
            sb.append(st.get(i));
        }
        
        return sb.toString();
    }
}