import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 수업 개수

        // 강의 시간 정렬
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 강의 시작
            int t = Integer.parseInt(st.nextToken());   // 강의 끝

            arr[i][0] = s;
            arr[i][1] = t;
        }
        Arrays.sort(arr, (a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];  // 우선 시작 시간 순서대로 정렬
        });

        // 끝나는 시간을 담기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        for(int i=1; i<n; i++){
            if(pq.peek() <= arr[i][0]){
                pq.poll();
            }
            pq.add(arr[i][1]);
        }

        System.out.print(pq.size());
    }
}