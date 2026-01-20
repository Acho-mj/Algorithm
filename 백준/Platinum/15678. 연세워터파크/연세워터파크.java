import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 징검다리[번호] = 정수값
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deq = new ArrayDeque<>();    // 현재 위치에서 갈 수 있는 징검다리의 인덱스 (1~N)
        long[] dp = new long[n+1];    // 현재 위치에서 가장 정수의 합이 큰 것
        long max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            // 인덱스 범위에서 벗어날 경우 삭제
            if (!deq.isEmpty() && deq.peekFirst() < i-d) {
                deq.removeFirst();
            }

            // deq가 비어있지 않으면 이전 최댓값을, 비어있다면 0을
            long preMax = deq.isEmpty() ? 0 : dp[deq.peekFirst()];
            dp[i] = arr[i] + Math.max(0, preMax);   // 마이너스일 경우 현재부터 다시 시작

            // 현재가 최대라면 이전 값은 삭제
            while(!deq.isEmpty() && dp[deq.peekLast()]<dp[i]){
                deq.removeLast();
            }
            deq.offer(i);
            max=Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}