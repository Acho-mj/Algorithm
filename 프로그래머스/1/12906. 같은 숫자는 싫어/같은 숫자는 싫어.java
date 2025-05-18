import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> q = new ArrayList<>();
        int beforeN = -1;
        
        // 중복 값 제거
        for(int num : arr){
            if(beforeN != num){
                q.add(num);
                beforeN = num;
            }
        }
        
        // List → int[] 변환
        int[] answer = new int[q.size()];
        for (int i = 0; i < q.size(); i++) {
            answer[i] = q.get(i);
        }

        return answer;
    }
}