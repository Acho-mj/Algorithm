import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] ds = new int[n]; // 자료구조
        int[] init = new int[n]; // 초기값
        Deque<Integer> dq = new ArrayDeque<>();

        // 자료구조 종류
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            ds[i] = Integer.parseInt(st.nextToken());
        }

        // 각 자료구조에 들어있는 값
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        // 자료구조에 넣어야 하는 값
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] number = new int[m];
        for(int i=0; i<m; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 큐 : 자료구조에 초기값 넣기
        int cnt=0;
        for(int i=0; i<n; i++){
            if(ds[i]==0){
                dq.offerFirst(init[i]);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        // number 값을 큐(0)일 때
        // 값을 뒤에 넣고, 앞에서 빼기
        for(int i=0; i<m; i++){
            if(dq.isEmpty()){
                sb.append(number[i]).append(" ");
            }else{
                dq.offerLast(number[i]);
                sb.append(dq.pollFirst()).append(" ");
            }
        }
        System.out.print(sb);
    }
}