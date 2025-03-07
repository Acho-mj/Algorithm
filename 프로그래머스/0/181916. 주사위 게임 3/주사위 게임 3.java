import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 1;
        int[] numArray = {a, b, c, d};
        int p = 0;
        int q = 0;
        
        // hashamp <주사위 숫자, 갯수>
        // 1. p 4개 -> 1111 * p   -> size 1
        // 2. p 3개, q 1개 -> (10 × p + q)2 -> size 2
        // 3. p 2개, q 2개 -> (p + q) × |p - q| -> size 2
        // 4. p 2개, q 1개, r 1개 -> q × r -> size 3
        // 5. 다 다를 경우 -> min -> size 4
        
        HashMap<Integer, Integer> num = new HashMap<>();
        
        // 각 숫자의 개수 저장
        for(int i=0; i<numArray.length; i++) {
            if(num.containsKey(numArray[i])){
                num.put(numArray[i], num.get(numArray[i])+1);
            }else{
                num.put(numArray[i], 1);
            }
        }
        
        // 해시맵 크기에 따른 경우의 수 처리
        switch(num.size()) {
            // 5. 다 다를 경우 -> min -> size 4
            case 4:
                answer = Math.min(Math.min(a, b), Math.min(c, d));
                break;  
                
            // 4. p 2개, q 1개, r 1개 -> q × r -> size 3    
            case 3:
                for(int key : num.keySet()){
                    if(num.get(key) == 1){
                        answer *= key;
                    }
                }
                break;
                
            case 2:
                // 2. p 3개, q 1개 -> (10 × p + q)2 -> size 2
                if(num.containsValue(3)){
                    for(int key : num.keySet()){
                        if(num.get(key) == 3){
                            p = key;
                        }else{
                            q = key;
                        }
                    }
                    answer = (int)Math.pow(10 * p + q, 2);
                    
                // 3. p 2개, q 2개 -> (p + q) × |p - q| -> size 2
                }else {
                    int[] pq = new int[2];
                    int index = 0;
                    for (int key : num.keySet()) {
                        pq[index++] = key;
                    }
                    answer = (pq[0] + pq[1]) * Math.abs(pq[0]-pq[1]);
                }                
                break;
                
            // 1. p 4개 -> 1111 * p   -> size 1
            case 1:
                answer = 1111 * a;
                break;
        }
        return answer;
    }
}