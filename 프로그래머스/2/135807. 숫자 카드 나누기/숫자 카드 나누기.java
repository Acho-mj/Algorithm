import java.util.*;
class Solution {
    boolean div = false;
    public int solution(int[] arrayA, int[] arrayB) {
        int max = 0;
        List<Integer> aList = new ArrayList<>();
        // arrayA = 철수가 가진 숫자
        // arrayB = 영희가 가진 숫자
        
        // arrayA의 약수이며 arrayB의 약수가 아닌 것 
        // arrayB의 약수이며 arrayA의 약수가 아닌 것 
        // 위의 두 조건 중 하나를 만족하면 a 임
        // a 중에서도 가장 큰 값 반환
        
        int gcdA=arrayA[0];
        // A배열에서의 모든 숫자들의 약수 구하기 
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB=arrayB[0];
        // B배열에서의 모든 숫자들의 약수 구하기 
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        // B배열에서의 약수가 아닌 것 (gcdA)
        if(!divide(gcdA, arrayB)){
            max=gcdA;
        }
        
        // A배열에서의 약수가 아닌 것 (gcdB)
        if(!divide(gcdB, arrayA)){
            max=Math.max(max, gcdB);
        }
        
        return max;
    }
    
    // 최대 공약수 구하기 
    private int gcd(int a, int b){
        while(b!=0){
            int tmp = b;
            b = a%b;
            a=tmp;
        }
        return a;
    }
    
    // 나누어 떨어지는지 확인
    private boolean divide(int a, int[] arr){
        for(int n : arr){
            if(n % a == 0){
                return true;
            }
        }
        return false;
    }
}