import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 토핑 종류의 가짓수가 동일하면 됨
        // 토핑 전체 개수
        int n = topping.length;
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        
        for(int top : topping){
            right.put(top, right.getOrDefault(top, 0)+1);
        }

        // 왼쪽에 토핑 넣으면서 오른쪽에 토핑 빼기
        for(int i=0; i<n; i++){ 
            int t = topping[i];
            left.add(t);

            // 오른쪽 토핑 빼면서 값이 0일 경우 key 삭제
            right.put(t, right.get(t)-1);
            if (right.get(t) == 0)
                right.remove(t);
            
            // 토핑 갯수 확인
            if(right.size()==left.size()){
                answer+=1;
            }
        }
        
        return answer;
    }
}