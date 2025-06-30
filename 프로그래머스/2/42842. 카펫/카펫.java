import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int row = 0;
        int col = 0;
        
        // 가로, 세로의 후보
        for(int i=3; i<=total/i; i++){
            // 약수일 경우에만
            if(total % i == 0){
                col = i;
                row = total/i;

                if((row - 2) * (col - 2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}