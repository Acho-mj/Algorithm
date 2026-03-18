import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] people = new int[n+1];    // 참여자의 차례 저장
        HashSet<String> set = new HashSet<>();  // 단어 중복 확인
        
        // 첫번째 단어
        set.add(words[0]);
        char prevLast = words[0].charAt(words[0].length() - 1);
        
        // words 만큼 반복
        for(int i=1; i<words.length; i++){
            int player = (i%n)+1;   // 플레이어의 번호
            int order = (i/n)+1;    // 플레이어의 말한 횟수
            
            String curStr = words[i];
            char curFirst = curStr.charAt(0);    // 단어의 첫번째 글자
            
            // 이전에 나온 적 있는 단어일 경우 OR 뒷글자와 앞글자가 다를 경우
            if(set.contains(curStr) || prevLast != curFirst){
                return new int[]{player, order};
            }
            
            set.add(curStr);  
            
            // 뒷글자 업데이트
            prevLast = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0}; // 탈락자가 없을 경우
    }
}