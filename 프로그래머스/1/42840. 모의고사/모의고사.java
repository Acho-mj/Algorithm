import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        int cntA=0;
        int cntB=0;
        int cntC=0;
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
        for(int i=0; i<n; i++){
            if(answers[i] == a[i%5]) cntA++;
            if(answers[i] == b[i%8]) cntB++;
            if(answers[i] == c[i%10]) cntC++;
        }
        
        // 최대값 찾기
        int max = Math.max(cntA, Math.max(cntB, cntC));

        // 최대값과 같은 사람 추가
        List<Integer> list = new ArrayList<>();
        if (cntA == max) list.add(1);
        if (cntB == max) list.add(2);
        if (cntC == max) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}