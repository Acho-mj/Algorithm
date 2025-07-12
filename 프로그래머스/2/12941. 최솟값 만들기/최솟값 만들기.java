import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        int n = A.length;

        // A는 작은 숫자부터
        // B는 큰 숫자부터 
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int j=0; j<n; j++){
            answer += A[j] * B[n-j-1];
        }
        
        return answer;
    }
}