import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 얼음 양동이 위치
        int[] arr = new int[1000000+1];
        Arrays.fill(arr, 0);
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());   // 얼음 양
            int x = Integer.parseInt(st.nextToken());   // 좌표
            arr[x]= g;
        }

        // 곰이 0의 위치에 있을 때
        long sum = 0;
        for(int i=0; i<2*k+1 && i <= 1000000; i++){
            sum += arr[i];
        }
        long max = sum;

        // 슬라이딩
        for(int i=1; i<=1000000; i++){
            int left = i-1; // 제거되는 인덱스
            int right = 2 * k + i;  // 추가되는 인덱스
            if(right > 1000000) break;
            sum = sum - arr[left] + arr[right];
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}