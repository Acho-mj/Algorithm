import java.util.*;
import java.io.*;

public class Main {
    static int start, target;
    static boolean[] prime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        Arrays.fill(prime, true);
        isPrime();

        // q1를 q2로 변환하는 최소 횟수
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            bfs();
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] dist = new int[10000]; // 단계
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            // 원하는 값을 찾을 경우 반환
            if(target == cur){
                System.out.println(dist[cur]);
                return;
            }

            // 자릿수
            for (int i = 0; i < 4; i++) {
                // 가능한 숫자 (0~9)
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) continue;  // 천의자리에 0 못 옴
                    int next = newPrime(cur, i, j);

                    if (prime[next] && dist[next] == -1) {
                        dist[next] = dist[cur] + 1;
                        q.add(next);
                    }
                }
            }
        }
        System.out.print("Impossible");
    }
    static int newPrime(int cur, int i, int j){
        char[] arr = String.valueOf(cur).toCharArray();
        arr[i] = (char)(j + '0');

        return Integer.parseInt(new String(arr));
    }

    static void isPrime(){
        prime[0] = prime[1] = false;
        for(int i=0; i*i<10000; i++){
            // 짝수일 경우 이미 false 처리됨 -> 건너뛰기
            if(!prime[i]) continue;
            for(int j=i*i; j<10000; j+=i){
                prime[j] = false;
            }
        }
    }
}