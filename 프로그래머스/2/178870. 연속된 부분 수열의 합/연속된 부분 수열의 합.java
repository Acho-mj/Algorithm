class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int minLen = n+1;
        
        int sum = 0;
        int left = 0; 
        int right = 0;
        
        // 부분 수열 인덱스
        int startIdx = -1;
        int endIdx = -1;
    
        // 슬라이딩
        for(right=0; right<n; right++){
            sum += sequence[right];
            
            // k보다 클 경우
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
            // k일 경우
            int len = right - left + 1;
            if(sum == k && minLen > len){
                minLen = len;
                startIdx = left;
                endIdx = right;
            }
        }
        
        return new int[]{startIdx, endIdx};
    }
}