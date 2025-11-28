import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long maxY = 0;
        for(int x=0; x<=d; x+=k){
            // 좌표 x에 대한 y의 갯수
            maxY = (long) (Math.pow(d, 2) - Math.pow(x,2));
            int count = (int) Math.sqrt(maxY);

            answer += count / k + 1;
        }
        return answer;
    }
}