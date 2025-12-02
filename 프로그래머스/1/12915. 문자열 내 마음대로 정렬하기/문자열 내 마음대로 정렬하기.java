import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        // list.get(i)[0] -> 인덱스 n에 해당하는 알파벳
        // list.get(i)[1] -> 단어
        ArrayList<String[]> list = new ArrayList<>();
        for(String str : strings){
            list.add(new String[]{String.valueOf(str.charAt(n)), str});
        }

        // 문자열의 인덱스 n번째 글자를 기준으로 오름차순, 그 이후는 사전순 오름차순 정렬
        Collections.sort(list, (a,b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i)[1];
        }
        return answer;
    }
}