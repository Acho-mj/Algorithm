class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // n만큼 뒤로 밀기
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){ // 공백
                sb.append(" ");
            }else if(c >= 'a' && c <= 'z'){
                // 소문자
                sb.append((char)('a' + (c - 'a' + n) % 26));
            }else{
                // 대문자
                sb.append((char)('A' + (c - 'A' + n) % 26));
            }
        }
        return sb.toString();
    }
}