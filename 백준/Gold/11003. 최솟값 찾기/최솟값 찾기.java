import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 110;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    // n개의 수
        int l = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            //새로 들어오는 값보다 기존 값이 클 경우 버리기
            while(!dq.isEmpty() && arr[dq.peekLast()] > arr[i]){
                dq.removeLast();
            }

            dq.offerLast(i);

            // 범위를 벗어나면 제거(인덱스)
            if(dq.peekFirst() <= i-l){
                dq.removeFirst();
            }
            sb.append(arr[dq.peekFirst()]).append(" ");
        }
        System.out.print(sb);
    }
}