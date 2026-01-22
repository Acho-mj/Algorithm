import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            String line = br.readLine();
            int m = Integer.parseInt(line); // m(수열의 크기)
            sb.append((m+1)/2).append("\n");

            // 나를 기준으로 큰 값은 right, 작은 값은 left
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());  // 큰 값 반환 -> 중앙값임
            PriorityQueue<Integer> right = new PriorityQueue<>();
            int cnt=0;
            int lineCount = 0; // 현재 줄에 출력한 중앙값 수

            while(cnt < m){
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int num = Integer.parseInt(st.nextToken());
                    cnt++;

                    // 현재 값이 큰 값인지 확인
                    if(!left.isEmpty() && left.peek() <= num){
                        right.add(num);
                    }else{
                        left.add(num);
                    }

                    // left 수가 적으면 right에서 빼오기
                    if(left.size() > right.size()+1){
                        right.add(left.poll());
                    }else if(left.size() < right.size()){
                        left.add(right.poll());
                    }

                    // 홀수일 경우
                    if(cnt%2 == 1){
                        sb.append(left.peek()).append(" ");
                        lineCount++;
                        if(lineCount == 10){
                            sb.append("\n");
                            lineCount = 0;
                        }
                    }
                }
            }
            if(lineCount > 0) sb.append("\n");
        }
        System.out.print(sb);
    }
}