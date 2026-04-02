class Solution {
    public String solution(int n, int t, int m, int p) {

        // 진법에 맞게 변환해서 저장
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m*t+1; i++){
            String str = Integer.toString(i, n).toUpperCase();
            sb.append(str);
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<t; i++){
            ans.append(sb.charAt(m*i+(p-1)));
        }
        return ans.toString();
    }
}