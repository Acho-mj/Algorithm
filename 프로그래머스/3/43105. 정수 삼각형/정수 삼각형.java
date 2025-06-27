class Solution {
    public int solution(int[][] triangle) {
        int row = triangle.length;  // 행 개수
        int[][] dp = new int[row][row];
        dp[0][0] = triangle[0][0]; 
        
        // dp[i][j] = 이전 위치 + 위치 (i, j)
        for(int i=1; i<row; i++){
            for(int j=0; j<=i; j++){
                // 왼쪽 테두리
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                // 오른쪽 테두리
                }else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        // 마지막 행 비교
        int max = 0;
        for(int i=0; i<row; i++){
            max = Math.max(max, dp[row-1][i]);
        }
        
        return max;
    }
} 