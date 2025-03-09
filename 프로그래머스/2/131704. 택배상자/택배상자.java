import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        // 컨테이너 벨트
        Queue<Integer> beltQ = new LinkedList<>();
        // 보조 컨테이너 벨트
        Stack<Integer> beltS = new Stack<>();
        
         // 컨테이너 벨트에 박스 추가 (1부터 n까지)
        for (int i = 1; i <= order.length; i++) {
            beltQ.add(i);
        }
        
        // 박스 개수
        int count = 0;
        // 인덱스
        int idx = 0;
        
        // 1. 컨테이너 벨트에서 바로 트럭으로
        // 2. 1번이 안되면 보조 컨테이너에 실어서 트럭으로
        // 3. 종료
    
        while(true){
            // 컨테이너 벨트 - order 배열
            if (!beltQ.isEmpty() && beltQ.peek() == order[idx]) {
                beltQ.poll();
                count++;
                idx++;
            // 보조 컨테이너 벨트에서 확인
            } else if (!beltS.isEmpty() && beltS.peek() == order[idx]) {
                beltS.pop();
                count++;
                idx++;
             // 컨테이너 벨트에서 꺼내 보조 벨트에 넣음
            } else if (!beltQ.isEmpty()) {
                beltS.push(beltQ.poll());
            } else {
                break;
            }
        }

        
        return count;
    }
}