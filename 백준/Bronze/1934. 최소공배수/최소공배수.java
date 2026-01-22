import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCM(A,B)).append("\n");
        }
        System.out.print(sb);
    }

    public static int GCD(int A, int B){
        if(B == 0) return A;
        return GCD(B, A % B);
    }

    public static int LCM(int A, int B){
        return A*B / GCD(A, B);
    }
}