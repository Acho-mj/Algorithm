import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());    // 테스트케이스 갯수

        while (t-- > 0) {
            String command = br.readLine(); // 함수
            int n = Integer.parseInt(br.readLine()); // 배열 크기
            String str = br.readLine(); // [1,2,3,4] 형태의 문자열

            Deque<Integer> dq = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(str, "[],");
            while(st.hasMoreTokens()){
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isFront = true;
            // R 순서 역순, D 첫번째 수 버리기(비어있을 경우네는 실행X)
            for(char c : command.toCharArray()){
                switch (c){
                    case 'R':
                        isFront = !isFront;
                        break;

                    case 'D':
                        if(dq.isEmpty()){
                            isError = true;
                            break;
                        }
                        // 앞에서부터 시작일 경우
                        if(isFront){
                            dq.pollFirst();
                        }else{
                            dq.pollLast();
                        }
                        break;
                }
            }
            // 에러일 경우
            if(isError){
                sb.append("error\n");
            }else{
                makeAnswer(dq, isFront, sb);
            }
        }
        System.out.print(sb);
    }

    public static void makeAnswer(Deque<Integer> dq, boolean isFront, StringBuilder sb){
        sb.append("[");
        while(!dq.isEmpty()){
            // 앞에서부터 시작일 경우
            if(isFront){
                sb.append(dq.pollFirst());
            }else{
                sb.append(dq.pollLast());
            }
            if (!dq.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
    }
}