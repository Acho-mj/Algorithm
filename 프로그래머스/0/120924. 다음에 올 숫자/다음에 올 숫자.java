class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int n = common.length;
        int last = common[n-1];
        
        if(common[1]-common[0] == common[2]-common[1]){
            int d = common[1]-common[0];
            answer = last + d;
        }else{
            int r = common[1]/common[0];
            answer = last * r;
        }
        
        return answer;
    }
}