class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int member = schedules.length;
        // 출근 희망 시각 + 10분 (h*100 + m)
        // 출근 희망 시각 schedules, 출근한 시각 timelogs[직원][j+1일차에 출근한 시각], 이벤트 시작 요일 startday(1=월, ..., 7=일)

        for(int i=0; i<member; i++){
            int targetHour = schedules[i] / 100;
            int targetMin = schedules[i] % 100 + 10;

            if (targetMin >= 60) {
                targetHour++;
                targetMin -= 60;
            }
            int limitTime = (targetHour * 100) + targetMin;
            
            boolean success = true;
            for(int j=0; j<7; j++){
                int day = (startday+j-1)%7 +1;
                if(day==6 || day ==7) {
                    continue;
                }
                if(limitTime<timelogs[i][j]){
                    success = false;
                    break;
                }
            }
            if(success){
                answer++;
            }
        }

        // 출근 희망 시각에 제대로 출근한 직원의 수
        return answer;
    }
}