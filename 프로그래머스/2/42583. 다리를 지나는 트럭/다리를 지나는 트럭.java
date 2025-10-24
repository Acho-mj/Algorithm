import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸리는 시간
        int sum = 0; // 다리를 건너는 트럭의 무게 합
        
        // 대기 트럭
        Queue<Integer> truckQ = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            truckQ.add(truck_weights[i]);
        }
        
        // 다리를 건너는 트럭
        Queue<Integer> crossQ = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            crossQ.add(0);
        }
        
        // 다리를 건너는 트럭이 없을 때까지 [0,0]
        while(!crossQ.isEmpty()){
            answer++;
            // 맨 앞 꺼내기
            sum -= crossQ.poll(); 

            if (!truckQ.isEmpty()) {
                int next = truckQ.peek();
                
                // 무게 조건 확인
                if (sum + next <= weight) { 
                    crossQ.add(truckQ.poll()); 
                    sum += next;
                } else {
                     // 조건에 맞는게 없으면 아무것도 X
                    crossQ.add(0); 
                }
            }
        }        
        return answer;
    }
}