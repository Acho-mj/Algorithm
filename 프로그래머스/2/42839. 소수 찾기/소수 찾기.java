import java.util.*;
class Solution {
    boolean[] visited;
    HashSet<Integer> number = new HashSet<>(); // 중복 제거된 숫자 조합들
    public int solution(String numbers) {
        int answer = 0;
        visited= new boolean[numbers.length()];

        // numbers 가 주어졌을 때 만들 수 잇는 소수가 몇개인지
        // 숫자 조합해서 Set 으로 중복 확인
        char[] num = numbers.toCharArray();

        dfs(num, visited, "");

        // 소수 갯수 카운팅
        for(int n : number){
            if(isprime(n)) answer++;
        }

        return answer;
    }

    // 순열 dfs
    public void dfs(char[] num, boolean[] visited, String str){
        int n = num.length;
        // 공백이 아닐 경우 hashSet에 값 넣기
        if(!str.equals("")){
            number.add(Integer.parseInt(str));
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(num, visited, str+num[i]);
                visited[i]=false; // 백트래킹
            }
        }
    }

    // 소수 확인
    public boolean isprime(int number){
        if (number < 2) return false;
        for(int i=2; i<=Math.sqrt(number); i++){
            // 소수 아님
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}