import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQ = new LinkedList<>();
        int n = progresses.length;
        
        List<Integer> answer = new ArrayList<>();
        
        // 큐에 작업 시간을 넣기
        // 진도는 99, 속도는 100일 경우 -> 1/100 = 0
        for(int i=0; i<n; i++){
            int day = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            dayQ.offer(day);
        }
        
        // 기능은 1번부터 완료되어야 함, 7, 3, 9
        // 1번의 dayQ이 9이고, 2,3 번이 9보다 작을 경우 9일째에 기능 3개 완료
        while(!dayQ.isEmpty()){
            int currentTime = dayQ.poll();
            int count = 1;

            while(!dayQ.isEmpty() && dayQ.peek() <= currentTime){
                dayQ.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}