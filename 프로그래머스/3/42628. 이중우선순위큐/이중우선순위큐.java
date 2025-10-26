import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        // 최소, 최대 삭제하기 위한 큐 생성
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    
        // op 값은 String이고 큐에 넣을 때는 숫자로 넣어야함.
        for(String op : operations){
            String[] value = op.split(" ");
            int valueInt = Integer.parseInt(value[1]);
            
            // 값 넣기 
            if(value[0].equals("I")){
                minQ.offer(valueInt);
                maxQ.offer(valueInt);
            // maxQ에서 최댓값 삭제
            }else if(value[0].equals("D")){
                if(minQ.isEmpty() || maxQ.isEmpty()) continue;
                
                if(valueInt==1){
                    // max 값
                    int max = maxQ.poll();
                    minQ.remove(max); // 큐끼리 동기화
                }else{
                    // min 값
                    int min = minQ.poll();
                    maxQ.remove(min);
                }   
            }
        }
        int max = maxQ.isEmpty() ? 0 : maxQ.peek();
        int min = minQ.isEmpty() ? 0 : minQ.peek();

        return new int[]{max, min};
    }
}