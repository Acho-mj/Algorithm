import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int arr : array){
            list.add(arr);
        }
        Collections.sort(list, Comparator.reverseOrder());
        
        // 내림차순 list에서 맨 앞에 꺼내와서 array와 비교하여 인덱스 구하기
        int cnt = 0;
        for(int arr : array){
            if(list.get(0) == arr){
                answer.add(list.get(0));
                answer.add(cnt);
            }else{
                cnt++;
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}