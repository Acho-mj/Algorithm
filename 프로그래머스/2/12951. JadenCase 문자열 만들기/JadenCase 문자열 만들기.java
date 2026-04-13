class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean isBlank = true;
        for(char c : s.toLowerCase().toCharArray()){
            if(c == ' '){
                answer.append(c);
                isBlank = true;
            }else{
                if (isBlank) {
                    answer.append(Character.toUpperCase(c));
                    isBlank = false;
                } else {
                    answer.append(c);
                }
            }
        }

        return answer.toString();
    }
}