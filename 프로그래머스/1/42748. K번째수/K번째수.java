import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i, j, k =0;
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int[] com : commands){
            i=com[0];
            j=com[1];
            k=com[2];
            
            // 배열 자르기
            int[] arr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(arr);
            answer.add(arr[k-1]);
        }
        
        int[] result = new int[answer.size()];
        for(int m=0; m<answer.size(); m++){
            result[m] = answer.get(m);
        }
        
        return result;
    }  
}