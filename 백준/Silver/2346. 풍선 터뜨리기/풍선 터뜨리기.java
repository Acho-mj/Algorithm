import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 풍선 안에 종이(-n ~ n) 사이의 정수가 들어있음
        st = new StringTokenizer(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int move = cur[1];

            sb.append(num).append(" ");

            if (q.isEmpty()) break;

            // 양수일 경우 (이후에 맨 앞에서 poll를 함)
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    q.offer(q.poll());
                }
            // 음수일 경우
            } else {
                for (int i = 0; i > move; i--) {
                    q.offerFirst(q.pollLast());
                }
            }
        }
        System.out.print(sb);
    }
}