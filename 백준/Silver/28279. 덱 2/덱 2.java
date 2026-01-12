import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());   // 명령의 갯수

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            int x=0;
            if(op == 1 || op ==2){
                x = Integer.parseInt(st.nextToken());
            }

            switch (op){
                case 1:
                    dq.offerFirst(x);
                    break;

                case 2:
                    dq.offerLast(x);
                    break;

                case 3:
                    // 정수가 있다면
                    if(!dq.isEmpty()){
                        sb.append(dq.pollFirst());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                case 4:
                    // 정수가 있다면
                    if(!dq.isEmpty()){
                        sb.append(dq.pollLast());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                case 5:
                    sb.append(dq.size()).append("\n");
                    break;

                case 6:
                    // 정수가 있다면
                    if(!dq.isEmpty()){
                        sb.append(0);
                    }else{
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;

                case 7:
                    // 정수가 있다면
                    if(!dq.isEmpty()){
                        sb.append(dq.peekFirst());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                case 8:
                    // 정수가 있다면
                    if(!dq.isEmpty()){
                        sb.append(dq.peekLast());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}