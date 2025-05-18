import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations); // 오름차순 정렬
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 전체 논문에서 h회 이상 인용된 논문 수
            if (citations[i] >= h) {
                return h;
            }
        }     
        return 0;
    }
}