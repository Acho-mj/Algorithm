import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : scoville) {
            minHeap.add(s); 
        }
        while(minHeap.size() >= 2 && minHeap.peek() < K){
            int m1 = minHeap.poll();
            int m2 = minHeap.poll();
            minHeap.add(m1+m2*2);
            answer += 1;
        }
        if(minHeap.peek() < K)
            return -1;
        return answer;
    }
}