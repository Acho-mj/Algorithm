import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        // 빵 - 야채 - 고기 - 빵
        // 빵:1, 야채:2, 고기:3
        // 포장하는 햄버거 갯수 반환
        // 큐에 순서대로 넣고 1231 형태일경우 +1 (연속된 숫자여야만 답임)

        Stack<Integer> stack = new Stack<>();
        for(int i:ingredient){
            stack.add(i);

            if(stack.size()>=4){
                int a=stack.get(stack.size() - 4);
                int b=stack.get(stack.size() - 3);
                int c=stack.get(stack.size() - 2);
                int d=stack.get(stack.size() - 1);

                if(a==1 && b==2 && c==3 && d==1){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}