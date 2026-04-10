import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;  
        int time = 0;
        int count = 0; // 완료된 작업
        int n = jobs.length;
        
        // 우선순위 : 소요시간, 요청시각, 번호
        // 요청시각을 기준으로 정렬 : jobs[요청시각][소요시간]
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 소요시간 순서대로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        // 완료된 작업이 n과 같아질 때까지
        while(count < n){
            // 현재 시간과 jobs의 첫번째 요청시간이 같을 경우
            while(idx < n && jobs[idx][0] <= time){
                pq.add(jobs[idx++]);
            }
            
            // pq에 처리할 값이 없으면 건너뜀
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            }else{
                int[] cur = pq.poll();
                int curTime = cur[0];
                int curDur = cur[1];
                
                answer += time + curDur - curTime;
                time += curDur;
                
                count ++;   // 작업 완료
            }   
        }
        
        return answer/n;
    }
}