import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 인형 개수
        int k = Integer.parseInt(st.nextToken());   // 덩어리 개수

        // 1이 k 개 이상 연속된 최소 집합의 크기
        st = new StringTokenizer(br.readLine());
        int[] doll = new int[n];
        ArrayList<Integer> lionIdx = new ArrayList<>();     // 라이언 인형의 위치(인덱스)
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            doll[i] = value;
            if(value == 1){
                lionIdx.add(i);
            }
        }

        if(lionIdx.size() < k){
            System.out.print(-1);
            return;
        }

        // 라이언 인형 인덱스부터 k개 연속 집합 찾기
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=lionIdx.size()-k; i++){
            int start = lionIdx.get(i);
            int end = lionIdx.get(i+k-1);
            int len = end - start + 1;
            min = Math.min(len, min);
        }

        System.out.print(min);
    }
}