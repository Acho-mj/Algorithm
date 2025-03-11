class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int a = 0;
        
        
        if(num%2!=0){
            a = total/num;
            for(int i=0; i<num; i++){
                answer[i] = a-(num/2) + i;
            }
                
        }else{
            a = total/num - (num-1)/2;
            for(int j=0; j<num; j++){
                answer[j] = a + j;
            }           
        }
        return answer;
    }
}