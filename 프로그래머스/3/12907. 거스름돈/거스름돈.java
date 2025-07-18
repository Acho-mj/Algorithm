class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0원을 만드는 경우는 1가지 
        
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= 1000000007;
            }
        }
        return dp[n];
    }
}