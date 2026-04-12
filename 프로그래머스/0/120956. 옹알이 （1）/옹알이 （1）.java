class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] baby = {"aya", "ye", "woo", "ma"};
        // 조카가 할 수 있는 말을 공백 처리
        for(String str : babbling){
            for(String bb : baby){
                str = str.replace(bb, " ");
            }
            
            if(str.trim().length() == 0){
                answer++;
            }
        }
        
        return answer;
    }
}