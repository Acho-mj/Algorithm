import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = 0;
        int m = people.length-1;
    
        // 오름차순 정렬
        Arrays.sort(people);
        
        while(n<=m){
            // 가장 가벼운 사람과 가장 무거운 사람
            if(people[n] + people[m] <= limit){
                n++;
            }
            m -= 1;
            answer += 1;
        }
        
        return answer;
    }
}