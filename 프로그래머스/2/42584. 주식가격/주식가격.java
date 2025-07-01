import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = prices.length;
        Queue<int[]> priceQ = new LinkedList<>();
        
        // 주식 prices 와 index 넣기
        for(int i=0; i<n; i++){
            priceQ.offer(new int[]{prices[i], i});
        }
        
        // 가격이 떨어지지 않은 기간 구하기
        while(!priceQ.isEmpty()){
            int[] current = priceQ.poll();
            int curPrice = current[0];
            int curIndex = current[1];
            int gap = 0;
            
            // 현재 가격과 큐에 들어있는 가격과 비교
            for(int[] cur : priceQ){
                int inPrice = cur[0];
                int inIndex = cur[1];
                
                if(curPrice <= inPrice){
                    gap = (n-1) - curIndex; 
                }else{
                    gap = inIndex - curIndex;
                    break;
                }            
            }
            answer.add(gap);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}