class Solution {
    public int solution(int storey) {
        int answer = 0;

        // 절댓값이 10c인 형태 (-1, -10, -100, 100, 10, 1...)
        // 현재 층 수 + 버튼에 적혀 있는 값 > 0
        // 버튼 한 번 당 마법의 돌 한 개 사용 -> 0층으로 가기 위해 필요한 마법의 돌의 최소값
        // 현재 층 : storey -> 과반수를 넘을경우 -에서 +, 과반수를 넘지 않을 경우 + 에서 +
        int cnt =0;
        while(storey>0){
            // 현재 자릿수
            int digit = storey % 10;
            // 다음 자릿수로 이동
            storey /= 10;

            // 과반수 안 넘으면
            if(digit < 5){
                answer+=digit;
            // 과반수 넘으면
            }else if(digit > 5){
                answer+=(10-digit);
                storey+=1;
            // digit 5일 경우 그 다음 자릿수 확인
            }else{
                // 과반수 넘으면
                if (storey % 10 >= 5) {
                    answer += 5;
                    storey += 1;
                } else {
                    answer += 5;
                }
            }
        }
        return answer;
    }
}