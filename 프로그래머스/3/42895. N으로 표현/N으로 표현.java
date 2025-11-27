import java.util.*;
class Solution {
    public int solution(int N, int number) {
        // number = N으로 사칙연산한 값
        // return N의 사용 횟수
        // dp[num] -> num이 2면 N을 2번 사용한것

        // dp[1]~dp[8] = 연산에 사용하는 N의 개수가 1~8
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0; i<=8; i++)
            dp.add(new HashSet<>());

        // 5, 55, 555 이런 숫자 넣어두기
        // i는 N을 사용하는 갯수
        for(int i=1; i<=8; i++){
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // dp[num]에서 값 가져와서 dp[num+1] 처리 ==> 최종적으로 number 되게 만들기
            // j는 N을 사용하는 갯수 쪼개기
            for(int j=1; j<i; j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        if(b!=0) dp.get(i).add(a/b);
                        dp.get(i).add(a*b);
                    }
                }
            }
            if(dp.get(i).contains(number)) return i;
        }
        // 최솟값이 8보다 크면 -1을 return
        return -1;
    }
}