import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 강의실 개수

        // 시작 시간을 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }

        // 사용 중인 강의실의 종료시간 - 빨리 끝나는 순서
        PriorityQueue<Integer> pqNum = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int[] cur = pq.poll();
            int curS = cur[0];
            int curE = cur[1];

            // 기존 강의실 사용 가능 (현재 강의 시작이 기존 강의실 종료보다 늦을 경우)
            if(!pqNum.isEmpty() && curS >= pqNum.peek()) {
                pqNum.poll();
            }
            pqNum.add(curE);
        }

        System.out.print(pqNum.size());
    }
}