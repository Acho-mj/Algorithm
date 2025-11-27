class Solution {
    public String solution(int n) {
        String answer = "";
        // 10 -> 10/3=3..1  -> 1
        // 3/3=1..0  -> 나머지가 0일 경우 4
        // 14의 역 -> 41이 답
        StringBuilder builder = new StringBuilder();
        while(n>0){
            int remain = n % 3;
            // 나머지가 0이면 4 넣고 아니라면 나머지값 넣기
            if(remain==0){
                builder.append(4);
                n = n/3 - 1;
            }else{
                builder.append(remain);
                n = n/3;
            }
        }
        return builder.reverse().toString();
    }
}