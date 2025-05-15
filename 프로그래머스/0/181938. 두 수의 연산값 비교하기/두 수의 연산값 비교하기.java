import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int ab = Integer.parseInt(""+a+b);
        int twoab = 2*a*b;
        answer = Math.max(ab, twoab);
        return answer;
    }
}