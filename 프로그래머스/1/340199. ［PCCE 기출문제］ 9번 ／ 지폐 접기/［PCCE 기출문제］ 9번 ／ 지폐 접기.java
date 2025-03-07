class Solution {
    public int solution(int[] wallet, int[] bill) {
        // 접은 횟수
        int count = 0;
        
        // 길이가 긴 쪽을 반으로 접음
        // 길이 - 소수점 이하 버림
        // 90도 돌림 -> 가로, 세로 바뀜
        
        // 지갑의 크기와 지폐의 크기 비교
        // 지갑의 크기와 지폐 돌린거 비교
        while(Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1]) || Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])){
            if(bill[1] < bill[0]){
                bill[0] = Math.round(bill[0]/2);
            }else{
                bill[1] = Math.round(bill[1]/2);
            }
            count++;
        }     
        return count;
    }
}