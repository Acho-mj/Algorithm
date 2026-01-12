import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 카드 n장

        // 1. 맨 위 카드 버리기
        // 2. 그 다음 맨 위 카드는 맨 아래로 보내기
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            dq.offerLast(i);
        }

        while(!dq.isEmpty()){
            if(dq.size()<=2){
                System.out.print(dq.pollLast());
                break;
            }
            dq.pollFirst();
            dq.offerLast(dq.pollFirst());
        }
    }
}