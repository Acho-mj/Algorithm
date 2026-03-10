import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 애플파이 갯수
        int k = Integer.parseInt(st.nextToken());   // 먹으려는 개수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 - 고정크기
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int max = sum;

        for(int i=k; i<n+k; i++){
            int j = i-k;
            sum = sum - arr[j%n] + arr[i%n];

            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}