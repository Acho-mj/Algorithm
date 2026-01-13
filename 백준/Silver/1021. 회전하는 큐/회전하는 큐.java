import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 큐의 크기 N
        int m = Integer.parseInt(st.nextToken());   // 뽑는 갯수 M

        st = new StringTokenizer(br.readLine());
        int[] op = new int[m];
        for(int i=0; i<m; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        // 양방향 순환 큐
        // 큐의 맨 앞에서 m에 해당하는 값들을 꺼낼 때 연산(왼쪽, 오른쪽 이동 연산)의 최소 횟수 구하기
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++){
            dq.offerLast(i);
        }

        int cnt=0;
        for(int i=0; i<m; i++){
            int target = op[i];
            int targetIdx = dq.indexOf(target);

            // dq 가변 (인덱스 : 0, 1, 2...)
            int half;
            if(dq.size() % 2 == 0){
                half = dq.size()/2 -1;
            }else{
                half = dq.size()/2;
            }

            if(targetIdx <= half){
                while(target != dq.peekFirst()){
                    cnt++;
                    // 왼쪽 이동
                    dq.offerLast(dq.pollFirst());
                }
            }else{
                while(target != dq.peekFirst()){
                    cnt++;
                    // 오른쪽 이동
                    dq.offerFirst(dq.pollLast());
                }
            }
            dq.pollFirst();
        }
        System.out.print(cnt);
    }
}