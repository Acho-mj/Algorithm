import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // n일차
        int x = Integer.parseInt(st.nextToken());

        // 1일차부터 N일차까지 방문자 수
        st = new StringTokenizer(br.readLine());
        int[] visitor = new int[n];
        for(int i=0; i<n; i++){
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 윈도우 (0부터 x-1 까지의 구간 값)
        long curSum = 0;
        for(int i=0; i<x; i++){
            curSum += visitor[i];
        }

        int count = 1;
        long max = curSum;
        for(int i=x; i<n; i++){
            curSum = curSum + visitor[i] - visitor[i-x];
            if(curSum > max){
                max = curSum;
                count = 1;  // 최댓값 갱신
            }else if(curSum == max){
                count++;
            }
        }

        // 출력, x일동안 가장 많이 들어온 방문자 수 \n 방문자수 최대인 기간 몇개인지
        StringBuilder sb = new StringBuilder();
        if(max == 0){
            sb.append("SAD");
        }else{
            sb.append(max).append("\n");
            sb.append(count);
        }
        System.out.print(sb);
    }
}