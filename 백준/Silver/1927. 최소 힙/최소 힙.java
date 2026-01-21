import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 최소 힙
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            // x가 자연수라면 배열에 add, 0이라면 poll
            if(x==0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                pq.add(x);
            }

        }
        System.out.print(sb);
    }
}