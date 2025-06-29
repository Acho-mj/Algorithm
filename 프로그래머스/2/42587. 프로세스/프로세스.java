import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        
        // 큐에 우선순위랑 인덱스 넣기
        Queue<int[]> waitQ = new LinkedList<>();
        for(int i=0; i<n; i++){
            waitQ.offer(new int[]{priorities[i], i});
        }
        
        int count = 0;  // 실행순서 
        while(!waitQ.isEmpty()){
            int[] current = waitQ.poll();
            int prior = current[0];  // 우선순위
            int index = current[1];  // 인덱스
            boolean HasHighPrior = false;  // 더 높은 우선순위
            
            // 현재 우선순위와 대기 큐에 있는 우선순위 비교
            for(int[] cur : waitQ){
                int waitPrior = cur[0]; // 대기 큐에 있는 프로세스의 우선순위
                if(waitPrior > prior){
                    HasHighPrior = true;
                    break;
                }
            }
            
            // 더 높은 우선순위가 있을 경우 현재 프로세스를 대기 큐에 넣음
            if(HasHighPrior){
                waitQ.offer(current);
            }else{
                count++;
                // location에 해당하는 프로세스의 실행 순서
                if(index == location){
                    answer = count;
                    break;
                }
            }           
        }       
        return answer;
    }
}