import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = String.valueOf(n).length(); // 숫자 자리
        int start = Math.max(1, n - 9 * len);

        // N의 생성자 M (256의 생성자 245)
        // M + 각 자릿수의 합 = N
        // 각 자릿수의 최대합 = 27
        // 생성자 범위 n-1 ~ n-27
        int answer=Integer.MAX_VALUE;
        boolean is = false;
        for(int i=start; i<n; i++){
            int sum = 0;
            int temp = i;
            while(temp>0){
                sum+=temp%10;
                temp/=10;
            }
            if(sum+i == n){
                answer = Math.min(i, answer);
                is=true;
            }
        }
        if(is){
            System.out.print(answer);
        }else{
            System.out.print(0);
        }
    }
}