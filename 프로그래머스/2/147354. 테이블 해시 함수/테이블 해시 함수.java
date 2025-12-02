import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int n = data.length;
        int m = data[0].length;
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] i : data){
            list.add(i);
        }
        // col 번째 컬럼의 값을 기준으로 오름차순 + 첫번째 컬럼으로 내림차순
        list.sort(Comparator.comparingInt((int[] a) -> a[col-1]).thenComparing((a,b) -> b[0]-a[0]));

        // 정렬된 데이터에서 각 컬럼의 값을 i로 나눈 나머지들의 합
        int sum_xor=0;
        for(int i=row_begin; i<=row_end; i++){
            int sum_i = 0;
            for(int j=0; j<m; j++){
                sum_i += list.get(i-1)[j] % i;
            }
            sum_xor ^= sum_i;
        }
        return sum_xor;
    }
}