import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for(int num : numbers){
            answer.add(num);
        }   
        return answer.stream()
                .mapToInt(i -> i * 2)
                .toArray(); 
    }
}