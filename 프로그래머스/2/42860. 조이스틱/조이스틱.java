class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
         // 알파벳 변경
        for(char c : name.toCharArray()){
            int next = c - 'A';
            int prev = 'Z' - c + 1;
            
            answer += Math.min(next, prev);
        }
        
        // 커서 이동
        int minMove = n-1;
        for(int i=0; i<n; i++){
            int next = i+1;
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            minMove = Math.min(minMove, i + (n-next) + Math.min(i, n-next));
        }
        
        return answer + minMove;
    }
}