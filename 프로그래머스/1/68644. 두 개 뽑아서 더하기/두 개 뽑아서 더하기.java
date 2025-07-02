import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();
        int n = numbers.length;
        
        // 배열에서 숫자 뽑아서 더한 다음 HashSet에 넣기
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                numSet.add(numbers[i] + numbers[j]);
            }
        }
        
        return numSet.stream().sorted().mapToInt(i->i).toArray();
    }
}