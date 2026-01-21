import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        // 양수, 음수 힙
        PriorityQueue<Integer> pos = new PriorityQueue<>();
        PriorityQueue<Integer> neg = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            // x가 자연수라면 배열에 add, 0이라면 poll
            if(x==0){
                // 둘 다 값이 있을 떄
                if(!pos.isEmpty() && !neg.isEmpty()){
                    if(Math.abs(pos.peek()) < Math.abs(neg.peek())){
                        sb.append(pos.poll()).append("\n");
                    }else{
                        sb.append(neg.poll()).append("\n");
                    }
                // 하나의 힙에만 값이 있을 때
                }else if(pos.isEmpty() && !neg.isEmpty()){
                    sb.append(neg.poll()).append("\n");
                }else if(neg.isEmpty() && !pos.isEmpty()){
                    sb.append(pos.poll()).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                if(x>0){
                    pos.add(x);
                }else{
                    neg.add(x);
                }
            }
        }
        System.out.print(sb);
    }
}