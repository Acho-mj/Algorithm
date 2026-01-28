import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 같은 원소 k개 이하

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[200001];
        int left = 0;
        int max_length = Integer.MIN_VALUE;
        // 수열 안에 연속된 숫자들이 k개 이하여야 함
        for(int right=0; right<n; right++){
            cnt[arr[right]]++;

            // arr[right] 값이 k개 이하가 될때까지 왼쪽에서 숫자 제거
            while(cnt[arr[right]] > k){
                cnt[arr[left]]--;
                left++;
            }
            max_length = Math.max(max_length, right - left + 1);
        }
        System.out.print(max_length);
    }
}