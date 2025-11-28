import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        // 시간 순으로 정렬 -> 빠른 시간부터 방 배정
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));

        // 큐에 저장된 종료시간과 book_time의 시작시간 비교
        // 큐에 종료시간 갱신
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(String[] time : book_time){
            int start = timecal(time[0]);
            int end = timecal(time[1]) + 10; // 청소시간 10분 포함
            
            // room에 있는 시간 비교 후 가능한 종료시간 갱신
            // 종료 >= 10 -시작일 경우 같은 방 배정
            if(!room.isEmpty() && room.peek() <= start){
                room.poll();
            }
            room.add(end);
        }

        return room.size();
    }

    // 시:분 구하기
    private int timecal(String time){
        String[] timestamp = time.split(":");
        String h = timestamp[0];
        String m = timestamp[1];
        int hm = Integer.parseInt(h)*60 + Integer.parseInt(m);
        return hm;
    }
}