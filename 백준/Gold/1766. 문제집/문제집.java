import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 문제 수
        int m = Integer.parseInt(st.nextToken());   // 문제에 대한 정보 개수

        // 풀어야 하는 문제
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 각 숫자의 pq 진입 차수
        int[] degree = new int[n+1];
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            // a번 문제 -> b 번 문제 순서대로 문제를 품
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            degree[b]++;
        }

        // degree가 0이면 pq에 넣기
        for(int i=1; i<=n; i++){
            if(degree[i]==0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int next : arr[cur]){
                degree[next]--;
                if(degree[next] == 0){
                    pq.add(next);
                }
            }
        }
        System.out.print(sb);
    }
}