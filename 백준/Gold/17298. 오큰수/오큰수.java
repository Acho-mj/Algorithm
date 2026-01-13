import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽 숫자 중 가장 큰 수이자 가장 처음 마주한 숫자 / 없으면 -1
        Deque<Integer> s = new ArrayDeque<>();
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            // 스택에 해결되지 않은 인덱스를 저장해두었다가 꺼냄
            while (!s.isEmpty() && number[s.peekLast()] < number[i]){
                answer[s.pollLast()] = number[i];
            }

            // 조건에 만족하지 않을 경우 stack에 넣기
            s.addLast(i);
        }

        // 스택에 인덱스가 남아있을 경우 조건에 만족하지 않는 것이므로 -1
        while(!s.isEmpty()){
            answer[s.pollLast()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}