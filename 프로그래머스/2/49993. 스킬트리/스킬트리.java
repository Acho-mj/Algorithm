import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 스킬트리에 있는 문자열 순회
        for(String str : skill_trees){
            Queue<Character> queue = new LinkedList<>();
            for(char c : skill.toCharArray()){
                queue.add(c);
            }
            boolean isVaild = true;
            
            // 스킬을 나타내는 문자열
            for(char ch : str.toCharArray()){
                // 선행스킬에 포함
                if(skill.indexOf(ch) != -1){
                    // 맨 앞
                    if(!queue.isEmpty() && queue.peek() == ch){
                        queue.poll();
                    }else{  // 선행스킬 순서에 위배될 경우
                        isVaild = false;
                        break;
                    }
                }
            }
            
            if(isVaild){
                answer++;
            }
        }
        
        return answer;
    }
}