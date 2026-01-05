import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int idx = 0;
        int[] number = new int[1001];
        for (int i=1; i<=b; i++) {
            for(int j=0; j<i; j++){
                if (idx == b) break;
                number[idx]=i;
                idx++;
            }
            if (idx == b) break;
        }

        int answer=0;
        for(int i=a-1; i<b; i++){
            answer+=number[i];
        }

        System.out.print(answer);
    }
}