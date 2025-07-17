import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0; 
        int a = 1;
        for(int i=a; i<=n; i++){
            sum += i;
            if(sum == n){
                answer += 1;
                sum = 0;
                a += 1;
                i = a - 1;
            }else if(sum > n){
                sum = 0;
                a += 1;
                i = a - 1; 
            }
        } 
        return answer;
    }
}