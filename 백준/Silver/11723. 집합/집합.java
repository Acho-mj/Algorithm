import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 메모리 제한
        int m = Integer.parseInt(br.readLine());

        int s = 0; // 공집합
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = 0;
            String op = st.nextToken(); // 연산

            // x 받기
            if(!op.equals("all") && !op.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            // 공집합에 대한 계산
            switch (op){
                case "add":
                    s |= 1 << (x-1);
                    break;

                case "remove":
                    s &= ~(1 << (x-1));
                    break;

                case "check":
                    if((s & (1 << (x - 1))) == 0){
                        sb.append("0\n");
                    }else{
                        sb.append("1\n");
                    }
                    break;

                case "toggle":
                    if((s & (1 << (x - 1))) == 0){
                        s |= 1 << (x-1);
                    }else{
                        s &= ~(1 << (x-1));
                    }
                    break;

                case "all":
                    s = (1 << 20)- 1;
                    break;

                case "empty":
                    s=0;
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}